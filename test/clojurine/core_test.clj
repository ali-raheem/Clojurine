(ns clojurine.core-test
  (:require [clojure.test :refer :all]
            [clojurine.core :refer :all]))

(deftest filter-non-letter-test
  (testing "filter-non-letter"
    (is (= '(\A \l \i) (filter-non-letter "Ali555%")))))

(deftest apply-str-test
  (testing "apply-str"
    (is (= (apply-str '(\A \l \i))  "Ali"))))

(deftest mung-test
  (testing "mung"
    (is (= "ail" (mung "Ali")))))

(deftest filter-non-letter-test
  (testing "filter-non-letter"
    (is (= '(\A \l \i) (filter-non-letter "Ali555%")))))

(deftest find-match-test
  (testing "find-match"
    (is (=  ((find-match "Ali") [] "Ali") ["Ali"]))))
