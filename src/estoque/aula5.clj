(ns estoque.aula5)

(def estoque {"Mochila" 5, "Camisetas" 10})
(println estoque)


(def estoque
  {"Mochila" 5
   "Camiseta" 10})

(println estoque)

(println "Temos" (count estoque) "elementos")
(println "As chaves são:" (keys estoque))
(println "Os valores são:" (vals estoque))

(println "##########")

(def estoque
  {:mochila 10
   :camiseta 5})

(println "Temos" (count estoque) "elementos")
(println "As chaves são:" (keys estoque))
(println "Os valores são:" (vals estoque))

(println (assoc estoque :cadeira 3))
(println estoque)

(println estoque)
(println (update estoque :mochila inc))
(println estoque)

(defn tira-um
  [valor]
  (println "Tirando um de"valor)
  (- valor 1))

(println (update estoque :mochila #(- % 1)))

(println (dissoc estoque :mochila))






(println "################")

(def pedido
  {:mochila {:quantidade 2, :preco 80}
   :camiseta {:quantidade 3, :preco 40}})
(println pedido)


(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)
(println (pedido :mochile))                                 ;mapa como função
(println (get pedido :caneta {}))                           ;mapa com valor padrão
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))
(println (:quantidade (:mochila (update-in pedido [:mochila :quantidade] inc))))





; THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))

(-> pedido
    :mochila
    :quantidade
    println)













