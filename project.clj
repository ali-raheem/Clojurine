(defproject clojurine "0.2.2-SNAPSHOT"
  :description "Anigram finder"
  :url "https://github.com/wolfmankurd/Clojurine"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clojurine.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
