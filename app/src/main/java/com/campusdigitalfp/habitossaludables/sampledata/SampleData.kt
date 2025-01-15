package com.campusdigitalfp.habitossaludables.sampledata

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import com.campusdigitalfp.habitossaludables.R
import com.campusdigitalfp.habitossaludables.screens.Habito

/**
 * Datos de ejemplo para Hábitos Saludables
 */
object SampleData {
    val habitSample = mutableStateListOf<Habito>()
    fun loadData(context: Context) {
        val h1 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.beber_agua),
            descripcion = context.getString(R.string.aseg_rate_de_beber_al_menos_2_litros_de_agua_al_d_a_para_mantenerte_hidratado)
        )
        habitSample.add(h1)
        val h2 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.ejercicio_diario),
            descripcion = context.getString(R.string.realiza_al_menos_30_minutos_de_ejercicio_cada_d_a_para_mantenerte_en_forma)
        )
        habitSample.add(h2)
        val h3 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.meditaci_n),
            descripcion = context.getString(R.string.dedica_10_minutos_al_d_a_a_la_meditaci_n_para_reducir_el_estr_s_y_mejorar_la_concentraci_n)
        )
        habitSample.add(h3)
        val h4 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.leer_un_libro),
            descripcion = context.getString(R.string.lee_al_menos_un_libro_al_mes_para_enriquecer_tu_conocimiento_y_estimular_tu_mente)
        )
        habitSample.add(h4)
        val h5 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.dormir_bien),
            descripcion = context.getString(R.string.intenta_dormir_entre_7_y_8_horas_cada_noche_para_mejorar_tu_salud_mental_y_f_sica)
        )
        habitSample.add(h5)
        val h6 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.comer_frutas_y_verduras),
            descripcion = context.getString(R.string.incluye_al_menos_5_porciones_de_frutas_y_verduras_en_tu_dieta_diaria_para_una_alimentaci_n_balanceada)
        )
        habitSample.add(h6)
        val h7 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.desconectar_de_las_pantallas),
            descripcion = context.getString(R.string.t_mate_un_descanso_de_las_pantallas_al_menos_una_hora_antes_de_dormir_para_mejorar_la_calidad_del_sue_o)
        )
        habitSample.add(h7)
        val h8 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.practicar_la_gratitud),
            descripcion = context.getString(R.string.anota_tres_cosas_por_las_que_est_s_agradecido_cada_d_a_para_fomentar_una_mentalidad_positiva)
        )
        habitSample.add(h8)
        val h9 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.planificar_el_d_a),
            descripcion = context.getString(R.string.dedica_unos_minutos_cada_ma_ana_para_planificar_tus_tareas_y_establecer_prioridades)
        )
        habitSample.add(h9)
        val h10 = Habito(
            id = habitSample.size,
            titulo = context.getString(R.string.socializar),
            descripcion = context.getString(R.string.con_ctate_con_amigos_y_familiares_al_menos_una_vez_a_la_semana_para_fortalecer_tus_relaciones)
        )
        habitSample.add(h10)
    }
}
