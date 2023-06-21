(ns estoque.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println "valor padrão nulo:" (get precos 17))
(println "valor padrão 0:" (get precos 17 0))


(println (conj precos 5))
(println precos)


(println (+ 5 1))
(println (inc 5))
(println (update precos 0 inc))
(println (update precos 2 inc))


(defn soma-3
  [valor]
  (println "Estou somando um em"valor)
  (+ valor 3))

(println (update precos 0 soma-3))