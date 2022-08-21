package com.axuna.toaster

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat

object Toaster {
    private val LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
    private var currentTypeface = LOADED_TOAST_TYPEFACE
    private var textSize = 16
    private var tintIcon = true
    private var allowQueue = true
    private var lastToast: Toast? = null
    private var richTextInflater: RichTextInflater? = null
    private var isDebug: Boolean = false


    fun setIsDebug(debug: Boolean): Toaster {
        isDebug = debug
        return this
    }

    fun setRichTextInflater(richTextInflater: RichTextInflater): Toaster {
        this.richTextInflater = richTextInflater
        return this
    }

    fun normal(context: Context, @StringRes message: Int): Toast {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, null, false)
    }

    
    fun normal(context: Context, message: CharSequence): Toast {
        return normal(context, message, Toast.LENGTH_SHORT, null, false)
    }

    
    fun normal(context: Context, @StringRes message: Int, icon: Drawable?): Toast {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, icon, true)
    }

    
    fun normal(context: Context, message: CharSequence, icon: Drawable?): Toast {
        return normal(context, message, Toast.LENGTH_SHORT, icon, true)
    }

    
    fun normal(context: Context, @StringRes message: Int, duration: Int): Toast {
        return normal(context, context.getString(message), duration, null, false)
    }

    
    fun normal(context: Context, message: CharSequence, duration: Int): Toast {
        return normal(context, message, duration, null, false)
    }

    fun normal(
        context: Context, @StringRes message: Int, duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(context, context.getString(message), duration, icon, true)
    }

    
    fun normal(
        context: Context, message: CharSequence, duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(context, message, duration, icon, true)
    }

    
    fun normal(
        context: Context, @StringRes message: Int, duration: Int,
        icon: Drawable?, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            icon,
            getColor(context, R.color.toaster__normal_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun normal(
        context: Context, message: CharSequence, duration: Int,
        icon: Drawable?, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            false,
            icon,
            getColor(context, R.color.toaster__normal_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    @JvmStatic
    
    fun richText(context: Context, message: CharSequence): Toast {
        return custom(
            context,
            message,
            true,
            null,
            getColor(context, R.color.toaster__normal_color),
            getColor(context, R.color.toaster__default_text_Color),
            Toast.LENGTH_SHORT,
            withIcon = false,
            shouldTint = false
        )
    }

    
    fun warning(context: Context, @StringRes message: Int): Toast {
        return warning(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    
    fun warning(context: Context, message: CharSequence): Toast {
        return warning(context, message, Toast.LENGTH_SHORT, true)
    }

    
    fun warning(context: Context, @StringRes message: Int, duration: Int): Toast {
        return warning(context, context.getString(message), duration, true)
    }

    
    fun warning(context: Context, message: CharSequence, duration: Int): Toast {
        return warning(context, message, duration, true)
    }

    
    fun warning(
        context: Context,
        @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            getDrawable(
                context,
                R.drawable.toaster_ic_error_outline_white_24dp
            ),
            getColor(context, R.color.toaster__warning_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun warning(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            false,
            getDrawable(
                context,
                R.drawable.toaster_ic_error_outline_white_24dp
            ),
            getColor(context, R.color.toaster__warning_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun info(context: Context, @StringRes message: Int): Toast {
        return info(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    
    fun info(context: Context, message: CharSequence): Toast {
        return info(context, message, Toast.LENGTH_SHORT, true)
    }

    
    fun info(context: Context, @StringRes message: Int, duration: Int): Toast {
        return info(context, context.getString(message), duration, true)
    }

    
    fun info(context: Context, message: CharSequence, duration: Int): Toast {
        return info(context, message, duration, true)
    }

    
    fun info(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            getDrawable(
                context,
                R.drawable.toaster_ic_info_outline_white_24dp
            ),
            getColor(context, R.color.toaster__info_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun info(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            false,
            getDrawable(
                context,
                R.drawable.toaster_ic_info_outline_white_24dp
            ),
            getColor(context, R.color.toaster__info_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun success(context: Context, @StringRes message: Int): Toast {
        return success(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    
    fun success(context: Context, message: CharSequence): Toast {
        return success(context, message, Toast.LENGTH_SHORT, true)
    }

    
    fun success(context: Context, @StringRes message: Int, duration: Int): Toast {
        return success(context, context.getString(message), duration, true)
    }

    
    fun success(context: Context, message: CharSequence, duration: Int): Toast {
        return success(context, message, duration, true)
    }

    
    fun success(
        context: Context,
        @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            getDrawable(context, R.drawable.toaster_ic_check_white_24dp),
            getColor(context, R.color.toaster__success_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun success(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            false,
            getDrawable(context, R.drawable.toaster_ic_check_white_24dp),
            getColor(context, R.color.toaster__success_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun error(context: Context, @StringRes message: Int): Toast {
        return error(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    
    fun error(context: Context, message: CharSequence): Toast {
        return error(context, message, Toast.LENGTH_SHORT, true)
    }

    
    fun error(context: Context, @StringRes message: Int, duration: Int): Toast {
        return error(context, context.getString(message), duration, true)
    }

    
    fun error(context: Context, message: CharSequence, duration: Int): Toast {
        return error(context, message, duration, true)
    }

    
    fun error(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            getDrawable(context, R.drawable.toaster_ic_clear_white_24dp),
            getColor(context, R.color.toaster__error_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun error(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            false,
            getDrawable(context, R.drawable.toaster_ic_clear_white_24dp),
            getColor(context, R.color.toaster__error_color),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            true
        )
    }

    
    fun custom(
        context: Context, @StringRes message: Int, isRichText: Boolean, icon: Drawable?,
        duration: Int, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            isRichText,
            icon,
            -1,
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            false
        )
    }

    
    fun custom(
        context: Context, message: CharSequence, isRichText: Boolean, icon: Drawable?,
        duration: Int, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            isRichText,
            icon,
            -1,
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            false
        )
    }

    
    fun custom(
        context: Context, @StringRes message: Int, isRichText: Boolean, @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            isRichText,
            getDrawable(context, iconRes),
            getColor(context, tintColorRes),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            shouldTint
        )
    }

    
    fun custom(
        context: Context, message: CharSequence, isRichText: Boolean, @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            message,
            isRichText,
            getDrawable(context, iconRes),
            getColor(context, tintColorRes),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            shouldTint
        )
    }

    
    fun custom(
        context: Context, @StringRes message: Int, isRichText: Boolean, icon: Drawable?,
        @ColorRes tintColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            isRichText,
            icon,
            getColor(context, tintColorRes),
            getColor(context, R.color.toaster__default_text_Color),
            duration,
            withIcon,
            shouldTint
        )
    }

    
    fun custom(
        context: Context, @StringRes message: Int, icon: Drawable?,
        @ColorRes tintColorRes: Int, @ColorRes textColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            false,
            icon,
            getColor(context, tintColorRes),
            getColor(context, textColorRes),
            duration,
            withIcon,
            shouldTint
        )
    }

    @SuppressLint("ShowToast")
    
    fun custom(
        context: Context, message: CharSequence, isRichText: Boolean, icon: Drawable?,
        @ColorInt tintColor: Int, @ColorInt textColor: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        val currentToast = Toast.makeText(context, "", duration)
        val toastLayout =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.toaster__toast_layout, null)
        val toastIcon = toastLayout.findViewById<ImageView>(R.id.toast_icon)
        val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
        val drawableFrame: Drawable? = if (shouldTint) defaultDrawableFrame(
            context,
            tintColor
        ) else getDrawable(
            context,
            R.drawable.toaster_shape_toast_bg
        )
        setBackground(toastLayout, drawableFrame)
        if (withIcon) {
            requireNotNull(icon) { "Avoid passing 'icon' as null if 'withIcon' is set to true" }
            setBackground(
                toastIcon,
                if (tintIcon) tintIcon(icon, textColor) else icon
            )
        } else {
            toastIcon.visibility = View.GONE
        }
        if (isRichText) {
            if (isDebug) {
                requireNotNull(richTextInflater) { "RichTextInflater must not be null if you want draw richText" }
            }
            if (richTextInflater != null) {
                richTextInflater!!.inflate(toastTextView, message.toString())
            } else {
                toastTextView.text = message
            }
        } else {
            toastTextView.text = message
        }
        toastTextView.setTextColor(textColor)
        toastTextView.typeface = currentTypeface
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        currentToast.view = toastLayout
        if (!allowQueue) {
            if (lastToast != null) lastToast!!.cancel()
            lastToast = currentToast
        }
        return currentToast
    }

    private fun tintIcon(drawable: Drawable, @ColorInt tintColor: Int): Drawable {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
        return drawable
    }

    private fun defaultDrawableFrame(context: Context, @ColorInt tintColor: Int): Drawable {
        val drawable = getDrawable(context, R.drawable.toaster_shape_toast_bg)
        return tintIcon(drawable!!, tintColor)
    }

    private fun setBackground(view: View, drawable: Drawable?) {
        view.background = drawable
    }

    private fun getDrawable(context: Context, @DrawableRes id: Int): Drawable? {
        return ContextCompat.getDrawable(context, id)
    }

    private fun getColor(context: Context, @ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }

    interface RichTextInflater {
        fun inflate(textView: TextView, richText: String)
    }
}