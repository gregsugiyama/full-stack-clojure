(ns frontend.views.core
  (:require 
   [reagent.core  :as reagent]
   [re-frame.core :as rf]
   [frontend.state.core]))

(defn ButtonPrimary
  [props children]
  [:div {:class "rounded-md
                 shadow"}
   [:a {:class "w-full 
                cursor-pointer
                flex 
                items-center 
                justify-center 
                px-8 
                py-3 
                border 
                border-transparent 
                text-base 
                font-medium 
                rounded-md 
                text-white 
                bg-indigo-600 
                hover:bg-indigo-700 
                md:py-4 
                md:text-lg 
                md:px-10"
        :on-click (:on-click props)} children]])

(defn ButtonSecondary
  [props children]
  [:div {:class "mt-3 sm:mt-0 sm:ml-3"}
   [:a {:class "w-full
                cursor-pointer
                flex
                items-center
                justify-center
                px-8
                py-3
                border
                border-transparent
                text-base
                font-medium
                rounded-md
                text-indigo-700
                bg-indigo-100
                hover:bg-indigo-200
                md:py-4
                md:text-lg
                md:px-10"
        :on-click (:on-click props)} children]])

(defn Root
  []
  (let [*count (rf/subscribe [:frontend.state.core/current-count])]
   [:main {:class "mt-10 mx-auto max-w-7xl px-4 sm:mt-12 sm:px-6 md:mt-16 lg:mt-20 lg:px-8 xl:mt-28"}
    [:div {:class "sm:text-center lg:text-left"} 
     [:h1 {:class "text-4xl tracking-tight font-extrabold text-gray-900 sm:text-5xl md:text-6xl"}"Current Count: " @*count]]
    [:div {:class "mt-5 sm:mt-8 sm:flex sm:justify-center lg:justify-start"}
     [ButtonPrimary {:on-click #(rf/dispatch [:frontend.state.core/increment])} "Increment"]
     [ButtonSecondary {:on-click #(rf/dispatch [:frontend.state.core/decrement])} "Decrement"]]]))

