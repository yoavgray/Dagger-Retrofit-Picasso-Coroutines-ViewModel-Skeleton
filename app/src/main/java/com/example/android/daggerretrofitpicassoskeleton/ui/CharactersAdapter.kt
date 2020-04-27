package com.example.android.daggerretrofitpicassoskeleton.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.daggerretrofitpicassoskeleton.R
import com.example.android.daggerretrofitpicassoskeleton.data.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_item.view.idView
import kotlinx.android.synthetic.main.character_item.view.imageView

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {
    private val characters = mutableListOf<Character>()

    fun addCharacters(newChars: List<Character>) {
        val startPosition = characters.size
        characters.addAll(newChars)
        notifyItemRangeInserted(startPosition, characters.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.character_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            itemView.idView.text = character.id.toString()
            Picasso.get().load(character.image).into(itemView.imageView)
        }
    }
}
