function id(item) {
	return document.getElementById(item);
}
function copiarValor(item,destinoValor) {
	id(destinoValor).value += id(item).value;
}
function borrar(item) {
	var campo = id(item);
	var fin;
	fin = campo.value.length;
	fin--;
	campo.value = campo.value.substring(0,fin);
}
function borradoCompleto(item) {
	id(item).value = "";
}