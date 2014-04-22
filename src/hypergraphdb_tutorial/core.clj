(ns hypergraphdb_tutorial.core
  (:import [org.hypergraphdb HGEnvironment HGQuery])
  (:gen-class :main true)
  (:use [clojure.tools.logging :only (info)]))


(def database (atom nil))
(def handle (atom nil))


(defn create-database
  "
  Creates a database or opens existing one from the folder specified by argument
  "
  [path]
  (let [dbinstance (HGEnvironment/get path)]
    (reset! database dbinstance)))


(defn add-example
  [example]
  (reset! handle (.add @database example)))


(defn get-data
  []
  (.get @database @handle))


(defn remove-example
  []
  (.remove @database @handle))


(defn close-graph
  []
  (.close @database))


(defn example-one
  []
  (do
    (create-database "hgdbtest")
    (add-example {:hello "world"})
    (println (get-data))
    (remove-example)
    (close-graph)
    ))


(defn -main
  []
  (example-one))
