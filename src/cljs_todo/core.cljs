(ns cljs-todo.core
  (:require [figwheel.client :as fw]
            [sablono.core :as html :refer-macros [html]]
            [quiescent.core :as q :include-macros true]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello world!"}))

(q/defcomponent Root
  [data]
  (html
    ;; Change h1 to h2 to see reload
    [:h1 (:text data)]))

(defn render [data]
  (q/render (Root data)
    (.getElementById js/document "app")))

(add-watch app-state ::render
    (fn [_ _ _ data] (render data)))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (swap! app-state identity)
)

(defonce whatever (render @app-state))
