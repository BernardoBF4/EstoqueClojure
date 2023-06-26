(ns estoque.aula6)

(def pedido
  {:mochila {:quantidade 2, :preco 80}
   :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15
  [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))


;(defn imprime-e-15
;  [chave valor]
;  (println "valor" valor "e" chave)
;  15)
;
;(println (map imprime-e-15 pedido))

(println "######")
(defn imprime-e-15
  [[chave valor]]
  (println "valor" valor "e chave" chave)
  15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produto
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produto pedido))
(println (reduce + (map preco-dos-produto pedido)))




(println "Versão com parâmetro da 'chave' que não era utilziado substituído por um _")
(defn preco-dos-produto
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println "Total por produto:" (map preco-dos-produto pedido))
(println "Total do pedido:" (reduce + (map preco-dos-produto pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produto pedido)))

(println (total-do-pedido pedido))


; THRED LAST: o parâmetro passado pra função vai no final da chamada.
; Então o (map preco-dos-produto ,,,) vai ter o parâmetro onde tem as vírgulas que eu adicionei;
; já no thread first, o parâmetro vem pro primeiro: assim -> (map ,,, preco-dos-produto)
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produto)
      (reduce +)))

(println "Total do pedido" (total-do-pedido pedido))





(defn preco-total-do-prduto
  [produto]
  (println "Produto"produto)
  (* (:quantidade produto) (:preco produto)))

(defn preco-total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-prduto)
       (reduce +)))

(println "Total do pedido" (preco-total-do-pedido pedido))






(def pedido
  {:mochila {:quantidade 2, :preco 80}
   :camiseta {:quantidade 3, :preco 40}
   :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println (filter gratuito? pedido))



(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter #(gratuito? (second %)) pedido))




(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 0}))
(println (pago? {:preco 30}))


(println ((comp not gratuito?) {:preco 50}))
(println ((comp not gratuito?) {:preco 0}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))






(def clientes
  [{:nome "Guilherme" :certificados ["Clojure" "Java" "Machine Learning"]}
   {:nome "Paulo" :certificados ["Java" "Ciência da Computação"]}
   {:nome "Daniela" :certificados ["Arquitetura" "Gastronomia"]}])

(println (->> clientes
              (map :certificados)
              (map count)
              (reduce +)))














