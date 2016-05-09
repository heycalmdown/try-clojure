(ns clj-helloworld.core)

(defn -main []
  "I can say 'Hello World'."
  (println "Hello World!"))

; condition
(let [need-to-grow-small (> 5 3)]
  (if need-to-grow-small
    "drink bottle"
    "don't drink bottle"))

(defn drink [need-to-grow-small]
  (when need-to-grow-small "drink bottle"))

(drink false)

(when-let [need-to-grow-small true]
  "drink bottle")

(let [bottle "drinkme"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"))

(let [x 5]
  (cond
    (> x 10) "bigger than 10"
    (> x 4) "bigger than 4"
    (> x 3) "bigger than 3"))


(let [bottle "mystery"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"
    :else "unknown"))

(let [bottle "mystery"]
  (case bottle
    "poison" "don't touch"
    "drinkme" "grow smaller"
    "empty" "all gone"
    "unknown"))

; currying
(defn grow [name direction]
  (if (= direction :small)
    (str name " is growing smaller")
    (str name " is growing bigger")))

((partial grow "Alice") :small)

(defn toggle-grow [direction]
  (if (= direction :small) :big :small))

(toggle-grow :big)
(toggle-grow :small)

(defn oh-my [direction]
  (str "Oh My! You are growing " direction))

(oh-my (toggle-grow :small))
(defn surprise [direction]
  ((comp oh-my toggle-grow) direction))

(surprise :small)

(defn adder [x y]
  (+ x y))

(adder 3 4)

(def adder-5 (partial adder 5))
(adder-5 10)

; destructuring - vector
(let [[color size] ["blue" "small"]]
  (str "The " color " door is " size))

(let [[color [size]] ["blue" ["very small"]]]
  (str "The " color " door is " size))

(let [[color [size] :as original] ["blue" ["small"]]]
  {:color color, :size size, :original original})

; destructuring - map
(let [{flower1 :flower1, flower2 :flower2}
      {:flower1 "red", :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))

(let [{flower1 :flower1, flower2 :flower2 :or {flower2 "missing"}}
      {:flower1 "red"}]
  (str "The flowers are " flower1 " and " flower2))

(let [{:keys [flower1 flower2]}
      {:flower1 "red" :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))
