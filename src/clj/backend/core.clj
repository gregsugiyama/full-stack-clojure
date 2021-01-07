(ns backend.core
  (:require
   [muuntaja.core                    :as m]
   [org.httpkit.server               :refer [run-server]]
   [reitit.ring                      :as ring]
   [reitit.ring.middleware.exception :refer [exception-middleware]]
   [reitit.ring.middleware.muuntaja  :refer [format-negotiate-middleware
                                             format-request-middleware
                                             format-response-middleware]]
   [ring.middleware.cors             :refer [wrap-cors]]
   [taoensso.timbre                  :as timbre]))

(def port 4000)

(defonce *server (atom nil))

(def app
  (ring/ring-handler
   (ring/router
    [["/ping" {:get (fn [req]
                      {:status 200
                       :body   "pong"})}]]
    {:data {:muuntaja   m/instance ; Can be configured with additional encoding options via m/create + { options }
            :middleware [[wrap-cors
                          :access-control-allow-origin [#"http://localhost:8080"]
                          :access-control-allow-methods [:get :put :post :delete]]
                         format-negotiate-middleware
                         format-request-middleware
                         exception-middleware
                         format-response-middleware]}})
   (ring/routes
    (ring/redirect-trailing-slash-handler)
    (ring/create-default-handler {:not-found (constantly {:status 404
                                                          :body "Route Not Found"})}))))

(defn -main
  []
  (timbre/info "Server Started On Port: " port)
  (reset! *server (run-server app {:port port})))

(defn stop-server
  []
  (when @*server
    (@*server :timeout 100)
    (reset! *server nil)))

(defn restart-server
  []
  (stop-server)
  (-main))

(comment
  (-main)
  (stop-server)
  (restart-server)
  (app {:request-method :get
        :uri "/"}))






