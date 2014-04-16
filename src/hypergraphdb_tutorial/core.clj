(ns hypergraphdb_tutorial.core
  (:import [org.hypergraphdb HGEnvironment])
  (:gen-class :main true)
  (:use [clojure.tools.logging :only (info)]))


(def database (atom nil))


(defn create-database
  "
  Creates a database or opens existing one from the folder specified by argument
  "
  [path]
  (let [dbinstance (HGEnvironment/get path)]
    (reset! database dbinstance)))


(defn -main
  "I don't do a whole lot."
  []
  (create-database "hgdbtest"))
