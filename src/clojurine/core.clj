(ns clojurine.core
  (:gen-class))

(defn filter-non-letter [x]
  (filter #(Character/isLetter %) x))

(defn apply-str [l]
  (apply str l))

(defn mung [w]
  (apply-str (sort w)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def mungm  (loop [mungm {}
                     keys (->> args
                               first
                               slurp
                               clojure.string/split-lines 
                               (map filter-non-letter)
                               (map apply-str))]
                (if (empty? keys) mungm
                    (recur
                       (let [key (first keys)]
                         (assoc mungm (mung key) key))
                       (rest keys))
                    )))
  (println (map second  (filter #(= (mung (second args)) (first %)) mungm))))
