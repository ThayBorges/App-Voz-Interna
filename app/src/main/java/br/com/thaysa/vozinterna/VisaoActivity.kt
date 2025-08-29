package br.com.thaysa.vozinterna

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import br.com.thaysa.vozinterna.databinding.ActivityVisaoBinding

class VisaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVisaoBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        // Simular gráfico de pizza com cores diferentes para cada status
        binding.pieChartEmAnalise.setBackgroundColor(getColor(R.color.warning))
        binding.pieChartRespondidas.setBackgroundColor(getColor(R.color.primary))
        binding.pieChartEncerradas.setBackgroundColor(getColor(R.color.secondary))
        
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
