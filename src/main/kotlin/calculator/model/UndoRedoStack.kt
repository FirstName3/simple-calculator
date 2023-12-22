package calculator.model

class UndoRedoStack<StateT> {

    private val undoStack: ArrayDeque<StateT> = ArrayDeque()
    private val redoStack: ArrayDeque<StateT> = ArrayDeque()

    fun push(state: StateT) {
        undoStack.addLast(state)
        redoStack.clear()
    }

    fun undo(state: StateT): StateT {
        val undo = undoStack.removeLastOrNull()
        if (undo == null) {
            return state
        } else {
            redoStack.addLast(state)
            return undo
        }
    }

    fun redo(state: StateT): StateT {
        val redo = redoStack.removeLastOrNull()
        if (redo == null) {
            return state
        } else {
            undoStack.addLast(state)
            return redo
        }
    }
}
