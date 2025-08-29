package br.com.thaysa.vozinterna

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.thaysa.vozinterna.databinding.ActivityRhBinding

class RHActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRhBinding
    private lateinit var adapter: RHAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadTodasDenuncias()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewTodasDenuncias.layoutManager = LinearLayoutManager(this)
        adapter = RHAdapter(
            onResponderClick = { denuncia ->
                Toast.makeText(this, "Respondendo denúncia ${denuncia.id}", Toast.LENGTH_SHORT).show()
            },
            onStatusClick = { denuncia ->
                Toast.makeText(this, "Alterando status da denúncia ${denuncia.id}", Toast.LENGTH_SHORT).show()
            },
            onDetalhesClick = { denuncia ->
                Toast.makeText(this, "Visualizando detalhes da denúncia ${denuncia.id}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.recyclerViewTodasDenuncias.adapter = adapter
    }

    private fun loadTodasDenuncias() {
        // Dados simulados de todas as denúncias com informações ASG
        val todasDenuncias = listOf(
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
            ),
            Denuncia(
                id = "4",
                tipo = "Assédio sexual",
                data = "12/11/2024",
                status = "Em análise",
                descricao = "Comportamento inadequado e assédio sexual no ambiente de trabalho.",
                setor = "Marketing",
                autor = "Ana Oliveira",
                identificacao = "EMP004",
                categoriaASG = "Social",
                prioridade = "Alta"
            ),
            Denuncia(
                id = "5",
                tipo = "Fraude",
                data = "08/11/2024",
                status = "Respondida",
                descricao = "Manipulação de relatórios financeiros para ocultar perdas.",
                setor = "Financeiro",
                autor = "Carlos Mendes",
                identificacao = "EMP005",
                categoriaASG = "Governança",
                prioridade = "Alta"
            )
        )
        
        adapter.submitList(todasDenuncias)
    }
}
