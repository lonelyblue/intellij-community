for (;;<error descr="Multiple expressions in 'for' update are not supported in current version">1, 2, 3</error>) {

}

for (<error descr="Multiple variables in 'for' initialization are not supported in current version">def a, b</error> ;;) {}

for (<error descr="Tuple declaration in 'for' initialization is not supported in current version">def (a, b) = c</error> ;;) {}
