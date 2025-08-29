package br.com.thaysa.vozinterna

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.thaysa.vozinterna.databinding.ActivityNovaDenunciaBinding

class NovaDenunciaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNovaDenunciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovaDenunciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinners()
        setupEnviarButton()
        setupToolbar()
    }

    private fun setupSpinners() {
        // Spinner para tipo de denúncia
        val tiposDenuncia = arrayOf(
            "Assédio moral",
            "Assédio sexual",
            "Discriminação",
            "Bullying",
            "Corrupção",
            "Fraude",
            "Violação ambiental",
            "Violação de segurança",
            "Outros"
        )
        
        val adapterTipos = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposDenuncia)
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoDenuncia.adapter = adapterTipos

        // Spinner para categoria ASG
        val categoriasASG = arrayOf(
            "Ambiental",
            "Social",
            "Governança"
        )
        
        val adapterASG = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoriasASG)
        adapterASG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategoriaASG.adapter = adapterASG

        // Spinner para setor
        val setores = arrayOf(
            "Recursos Humanos",
            "Financeiro",
            "Operações",
            "TI",
            "Marketing",
            "Vendas",
            "Administrativo",
            "Outros"
        )
        
        val adapterSetores = ArrayAdapter(this, android.R.layout.simple_spinner_item, setores)
        adapterSetores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSetor.adapter = adapterSetores
    }

    private fun setupEnviarButton() {
        binding.btnEnviarDenuncia.setOnClickListener {
            if (validateForm()) {
                // Simular envio da denúncia
                Toast.makeText(this, "Denúncia enviada com sucesso ao setor de compliance!", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun validateForm(): Boolean {
        val tipo = binding.spinnerTipoDenuncia.selectedItem.toString()
        val categoriaASG = binding.spinnerCategoriaASG.selectedItem.toString()
        val setor = binding.spinnerSetor.selectedItem.toString()
        val local = binding.etLocal.text.toString().trim()
        val hora = binding.etHora.text.toString().trim()
        val descricao = binding.etDescricao.text.toString().trim()

        return tipo.isNotEmpty() && 
               categoriaASG.isNotEmpty() && 
               setor.isNotEmpty() && 
               local.isNotEmpty() && 
               hora.isNotEmpty() && 
               descricao.isNotEmpty()
    }
}
