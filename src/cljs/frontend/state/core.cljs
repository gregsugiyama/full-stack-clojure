(ns frontend.state.core
  (:require
   [re-frame.core :as rf]))

(def default-db {::count 0})

(rf/reg-event-db
 ::initialize-db
 (fn [_ _] 
   default-db))

(rf/reg-sub
 ::current-count
 (fn [db]
   (get db ::count)))

(rf/reg-event-db
 ::increment
 (fn [db _]
   (update db ::count inc)))

(rf/reg-event-db
 ::decrement
 (fn [db _]
   (update db ::count dec)))
