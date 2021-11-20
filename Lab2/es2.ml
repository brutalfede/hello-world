(*2.1*)
let init len f =
 if(len<0) then raise (Invalid_argument "list length must be a positive number!")
else 
 let rec aux acc cont= 
    if(cont = len) then acc
    else aux (acc @ [f cont]) (cont+1)
in aux [] 0
;;

init 0 (fun x->x);; (*=[]*)
init 5 (fun x->x);; (*= [0; 1; 2; 3; 4] *)
init 5 ((+) 1);;  (*= [1; 2; 3; 4; 5]*) (* (+) 1 equivale a fun x -> 1+x *)
init 10 (fun x->x*x) ;;(* = [0; 1; 4; 9; 16; 25; 36; 49; 64; 81]*)

(*2.2*)
let combine l1 l2=
  if (List.length l1) != (List.length l2) then
        raise (Invalid_argument "combine")
  else  let rec aux acc = function
           [],[] -> acc
          |h1::t1,h2::t2-> aux (acc@[(h1,h2)]) (t1,t2)
          | _ , _ -> acc
 in aux [] (l1,l2)
;;


combine [] [];; (*=[]*)
combine [1;2;3] ["a";"b";"c"];; (*=[(1, "a"); (2, "b"); (3, "c")]*)
combine [1;2] ["a";"b";"c"];; (*Exception: Invalid_argument "combine*)