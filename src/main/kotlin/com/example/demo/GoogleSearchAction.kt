package com.example.demo

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.CaretModel
import com.intellij.openapi.editor.Editor

class GoogleSearchAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) { // called when the action is performed
        val editor: Editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val caretModel: CaretModel = editor.caretModel
        val selectedText = caretModel.currentCaret.selectedText
        BrowserUtil.browse("https://www.google.com/search?q=$selectedText")
    }

    override fun update(e: AnActionEvent) { // to update the state of the action, such as its visibility and enabled status
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val caretModel = editor.caretModel
        e.presentation.isEnabledAndVisible = caretModel.currentCaret.hasSelection()
    }
}