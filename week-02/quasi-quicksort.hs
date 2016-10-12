quasiQuicksort :: (Ord a) => [a] -> [a]
quasiQuicksort [] = []
quasiQuicksort (head:tail) = smaller ++ [pivot] ++ larger
                           where pivot = head
                                 smaller = filter (< pivot) (quasiQuicksort tail)
                                 larger = filter (> pivot) (quasiQuicksort tail)