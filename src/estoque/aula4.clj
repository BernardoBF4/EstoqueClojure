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






(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))




(println (filter aplica-desconto? precos))
(println (map valor-descontado (filter aplica-desconto? precos)))

(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "Somando"valor-1"e"valor-2)
  (+ valor-1 valor-2))

(println "######")
(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma 0 [15]))








