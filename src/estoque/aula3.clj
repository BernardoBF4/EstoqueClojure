(ns estoque.aula3)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))

(println (valor-descontado 100))

; PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))
(println (valor-descontado 100))





(defn aplica-desconto?
  [valor-bruto]
  (println "chamando nova versão")
  (if (> valor-bruto 100)
    true))

(println (valor-descontado 1000))
(println (valor-descontado 100))







(defn aplica-desconto?
  [valor-bruto]
  (println "chamando nova versão when")
  (when (> valor-bruto 100)
    true))

(println (valor-descontado 1000))
(println (valor-descontado 100))





(defn aplica-desconto?
  [valor-bruto]
  (println "chamando nova versão direta")
  (> valor-bruto 100))

(println (valor-descontado 1000))
(println (valor-descontado 100))





(println "#######################################")

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))

; HIGHER ORDER FUNCTIONS
; IMUTABILIDADE (a exemplos dos vetores)


(println "#### Função sem nome (anônima) ###########################")
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))


(println "#### Função sem nome (anônima) abreviada ###########################")
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))


(println "#### Função sem nome (anônima) abreviada só com um parâmetro ###########################")
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

(def mais-caro-que-100? #(> % 100))
(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))


