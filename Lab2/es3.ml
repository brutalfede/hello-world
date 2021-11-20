type 'a option = None | Some of 'a;;

let rec min_el ls = function
  [] -> None
  | [x] -> Some x
  | hd::tl ->  min hd (min_el tl)
  ;;

min_el []; (*= None*)
min_el [3;4;6;-1]; (*= Some (-1)*)
min_el ["orange";"apple";"banana"]; (*=Some "apple"*)



