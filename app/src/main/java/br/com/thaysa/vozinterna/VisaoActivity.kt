package br.com.thaysa.vozinterna

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import br.com.thaysa.vozinterna.databinding.ActivityVisaoBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class VisaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVisaoBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pieChart = findViewById(R.id.pieChart)

        setupDrawerLayout()
        setupNavigationMenu()
        setupDashboardContent()
        setupVozInternaInfo()
    }

    private fun setupDrawerLayout() {
        drawerLayout = binding.drawerLayout
        binding.toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(binding.navView)
        }
    }

    private fun setupNavigationMenu() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_visao_empresa -> {
                    // Já estamos na tela de visão da empresa
                    drawerLayout.closeDrawer(binding.navView)
                    true
                }
                R.id.nav_fazer_denuncia -> {
                    startActivity(Intent(this, NovaDenunciaActivity::class.java))
                    drawerLayout.closeDrawer(binding.navView)
                    true
                }
                R.id.nav_minhas_denuncias -> {
                    startActivity(Intent(this, MinhasDenunciasActivity::class.java))
                    drawerLayout.closeDrawer(binding.navView)
                    true
                }
                R.id.nav_rh -> {
                    startActivity(Intent(this, RHActivity::class.java))
                    drawerLayout.closeDrawer(binding.navView)
                    true
                }
                R.id.nav_deslogar -> {
                    // Voltar para tela de login
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupDashboardContent() {
        // Configurar estatísticas das denúncias
        binding.tvDenunciasTotal.text = "Total: 45"
        binding.tvDenunciasAnalise.text = "Em análise: 12"
        binding.tvDenunciasRespondidas.text = "Respondidas: 28"
        binding.tvDenunciasEncerradas.text = "Encerradas: 5"
        
        // Configurar gráfico de pizza simulado
        setupPieChart()
    }

    private fun setupPieChart() {
        // Gráficos
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(12f, "Ambiental"))
        entries.add(PieEntry(28f, "Social"))
        entries.add(PieEntry(5f, "Governança"))

        val colors = ArrayList<Int>()
        colors.add(Color.parseColor("#4CAF50")) // Verde para Ambiental
        colors.add(Color.parseColor("#F44336")) // Vermelho para Social
        colors.add(Color.parseColor("#2196F3")) // Azul para Governança

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = colors // Aplica as cores definidas
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 14f

        val data = PieData(dataSet)
        data.setDrawValues(true) // Mostra os valores numéricos nas fatias
        data.setValueFormatter(PercentFormatter(pieChart)) // Formata os valores como porcentagem
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.WHITE)

        pieChart.data = data
        pieChart.invalidate()

        pieChart.description.isEnabled = false // Remove o texto de descrição padrão
        pieChart.isDrawHoleEnabled = true      // Cria um buraco no meio (formato de donut)
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.setUsePercentValues(true)     // Faz com que o gráfico use porcentagens para os cálculos
        pieChart.setEntryLabelTextSize(12f)
        pieChart.setEntryLabelColor(Color.BLACK) // Cor dos rótulos (Ambiental, Social...)
        pieChart.centerText = "Total\nDenúncias" // Texto no centro do donut
        pieChart.setCenterTextSize(18f)

        // Configurar a legenda
        val legend = pieChart.legend
        legend.isEnabled = true
        legend.textSize = 14f

        // Adicionar uma animação
        pieChart.animateY(1400)

        // Adicionar texto explicativo sobre o gráfico
        binding.tvPieChartInfo.text = "Gráfico de pizza mostrando a distribuição das denúncias por status"
    }

    private fun setupVozInternaInfo() {
        // Configurar informações sobre o Voz Interna
        binding.tvVozInternaTitle.text = "O que é o Voz Interna?"
        binding.tvVozInternaDescription.text = "O Voz Interna é um aplicativo corporativo voltado para colaboradores realizarem denúncias relacionadas a práticas ASG (Ambientais, Sociais e de Governança) diretamente ao setor de compliance da empresa. Este canal seguro permite que você reporte situações que violem nossos valores e políticas corporativas."
        
        binding.tvObjetivoTitle.text = "Objetivo"
        binding.tvObjetivoDescription.text = "Promover um ambiente de trabalho ético, seguro e sustentável, garantindo que todas as denúncias sejam tratadas com confidencialidade e investigadas adequadamente pelo setor de compliance."
    }
}
