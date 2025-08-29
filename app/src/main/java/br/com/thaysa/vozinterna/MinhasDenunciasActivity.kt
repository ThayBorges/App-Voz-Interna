package br.com.thaysa.vozinterna

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.thaysa.vozinterna.databinding.ActivityMinhasDenunciasBinding

class MinhasDenunciasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMinhasDenunciasBinding
    private lateinit var adapter: DenunciaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMinhasDenunciasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadDenuncias()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewMinhasDenuncias.layoutManager = LinearLayoutManager(this)
        adapter = DenunciaAdapter()
        binding.recyclerViewMinhasDenuncias.adapter = adapter
    }

    private fun loadDenuncias() {
        // Dados simulados das denúncias do usuário com informações ASG
        val denuncias = listOf(
            Denuncia(
                id = "1",
                tipo = "Assédio moral",
                data = "15/11/2024",
                status = "Em análise",
                descricao = "Situação de assédio moral no ambiente de trabalho, com comentários inadequados e pressão psicológica constante.",
                setor = "Recursos Humanos",
                autor = "João Silva",
                identificacao = "EMP001",
                categoriaASG = "Social",
                prioridade = "Alta"
            ),
            Denuncia(
                id = "2",
                tipo = "Violação ambiental",
                data = "10/11/2024",
                status = "Respondida",
                descricao = "Descarte inadequado de resíduos químicos no setor de produção, violando protocolos ambientais.",
                setor = "Operações",
                autor = "Maria Santos",
                identificacao = "EMP002",
                categoriaASG = "Ambiental",
                prioridade = "Média"
            ),
            Denuncia(
                id = "3",
                tipo = "Corrupção",
                data = "05/11/2024",
                status = "Encerrada",
                descricao = "Solicitação de propina para aprovação de contratos com fornecedores.",
                setor = "Financeiro",
                autor = "Pedro Costa",
                identificacao = "EMP003",
                categoriaASG = "Governança",
                prioridade = "Alta"
            )
        )
        
        adapter.submitList(denuncias)
    }
}
