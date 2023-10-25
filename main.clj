(defn group-blog-entries [blog-entries]
  (let [expanded-entries (for [entry blog-entries
                               tag (:tags entry)]
                           (assoc entry :tag tag))]
    (let [grouped (group-by :tag expanded-entries)]
      (into {}
            (for [[tag entries] grouped]
              [tag (sort-by :date entries)])))))

(def blog-entries
  [{:title "Entry 1", :tags ["programming" "clojure"], :date "2023-10-15"}
   {:title "Entry 2", :tags ["programming" "java"], :date "2023-10-10"}
   {:title "Entry 3", :tags ["programming" "clojure"], :date "2023-10-12"}
   {:title "Entry 4", :tags ["devops" "docker"], :date "2023-10-14"}])

(def grouped-entries (group-blog-entries blog-entries))

(println grouped-entries)