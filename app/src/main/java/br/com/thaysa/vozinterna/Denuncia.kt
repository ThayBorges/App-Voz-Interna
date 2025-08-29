package br.com.thaysa.vozinterna

data class Denuncia(
    val id: String,
    val tipo: String,
    val data: String,
    val status: String,
    val descricao: String,
    val setor: String = "",
    val autor: String = "",
    val identificacao: String = "",
    val categoriaASG: String = "", // Ambiental, Social ou Governança
    val prioridade: String = "Média",
    val anonimo: Boolean = false,
    val local: String = "",
    val hora: String = ""
)
