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
  (testing "add-match ail = Ali"
    (is (=  ((add-match "ail") [] "Ali") ["Ali"])))
  (testing "add-match Ail = Ali"
    (is (=  ((add-match "Ail") [] "Ali") ["Ali"])))
  (testing "add-match Ali = Ali"
    (is (=  ((add-match "Ali") [] "Ali") ["Ali"]))))


