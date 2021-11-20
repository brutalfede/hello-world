(*1.1*)

let cat l =
  let rec aux acc = function
    [] -> acc
    | h::t -> aux (acc^h) t
in aux "" l
;;

cat ["This";" is ";"awesome!"];; (*= "This is awesome!" *)

(* Fold_left version *)
let fold_cat = List.fold_left (^) "";;

fold_cat ["This";" is ";"awesome!"];;

(*1.2*)

let filter p =
  let rec aux acc = function
   hd::tl -> if (p hd) then aux (hd::acc) tl else aux acc tl
   | _ -> acc
 in aux [] 
 ;;

filter ((< ) 0) [-1;1;2;-2];; (*= [1;2]*) (* (<) 0 equivale a fun x -> 0<x *)


(* Fold_left version *)
let fold_filter p = List.fold_left (fun acc hd-> if (p hd) then (hd::acc) else  acc ) [];;

fold_filter ((< ) 0) [-1;1;2;-2];; (* (<) 0 equivale a fun x -> 0<x *)




(*Problema, viene stampata al contrario e non riesco a trovare altro modo *)