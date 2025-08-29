package br.com.thaysa.vozinterna

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.thaysa.vozinterna.databinding.ItemDenunciaBinding

class DenunciaAdapter : ListAdapter<Denuncia, DenunciaAdapter.DenunciaViewHolder>(DenunciaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DenunciaViewHolder {
        val binding = ItemDenunciaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DenunciaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DenunciaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DenunciaViewHolder(private val binding: ItemDenunciaBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(denuncia: Denuncia) {
            binding.tvTipoDenuncia.text = denuncia.tipo
            binding.tvDataDenuncia.text = denuncia.data
            binding.tvStatusDenuncia.text = denuncia.status
            binding.tvDescricaoDenuncia.text = denuncia.descricao
            
            // Definir cor do status
            val statusColor = when (denuncia.status) {
                "Em análise" -> 0xFFDC602E.toInt() // Laranja
                "Respondida" -> 0xFF05A8AA.toInt() // Azul
                "Encerrada" -> 0xFFB8D5B8.toInt() // Verde
                else -> 0xFFBC412B.toInt() // Vermelho
            }
            binding.tvStatusDenuncia.setTextColor(statusColor)
        }
    }

    private class DenunciaDiffCallback : DiffUtil.ItemCallback<Denuncia>() {
        override fun areItemsTheSame(oldItem: Denuncia, newItem: Denuncia): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Denuncia, newItem: Denuncia): Boolean {
            return oldItem == newItem
        }
    }
}
