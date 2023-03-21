package com.rode_legal_pneus.ui.pneus.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.rode_legal_pneus.R
import com.rode_legal_pneus.ui.pneus.models.Pneus
import org.checkerframework.checker.units.qual.m

class PneusAdapter(var context: Context, var list: List<Pneus>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p: Int, p1: View?, p2: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_pneus, null)

        var marca = view.findViewById<TextView>(R.id.marcaItem)
        marca.text = list[p].marca

        var image = view.findViewById<ImageView>(R.id.imageItem)
        image.load(list[p].image)

        var pesoSuportado = view.findViewById<TextView>(R.id.pesoItem)
        pesoSuportado.text = list[p].pesoSuportado

        var largura = view.findViewById<TextView>(R.id.larguraItem)
        largura.text = list[p].largura

        return view
    }
}