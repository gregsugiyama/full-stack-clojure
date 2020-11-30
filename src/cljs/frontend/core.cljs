(ns frontend.core
  (:require
   [frontend.state.core]
   [frontend.views.core :as views]
   [reagent.core        :as rc]
   [reagent.dom         :as rd]
   [re-frame.core       :as rf]))

(defn ^:export init
  []
  (rd/render
   [views/Root]
   (.getElementById js/document "app")))

(def *first-time? (rc/atom true))

(defn init-re-frame!
  []
  (rf/dispatch-sync [:frontend.state.core/initialize-db]))

(when @*first-time?
  (init-re-frame!)
  (reset! *first-time? false))

(init)
