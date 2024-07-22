package org.example.hash_table_13


interface Cache<K, V>{

    fun set(key: K, value: V)

    fun get(key: K): V?

    fun size(): Int

    fun remove(key: K): Boolean
}

interface LinkedList<T>{
    data class Node<T>(
        val next: Node<T>? = null,
        val prev: Node<T>? = null,
        var value: T
    )

    val head: Node<T>
    val tail: Node<T>

    fun moveHead(
        node: Node<T>
    )

    fun remove(
        node: Node<T>
    )

    fun enqueue(
        node: Node<T>
    )

    fun dequeue(): Node<T>
}

class LRUISBNCache(
    val size: Int,
    val isbnMap : HashMap<String, LinkedList.Node<Pair<String, Float>>> = HashMap(size),
    val lruLinkedList: LinkedList<Pair<String,Float>>
): Cache<String, Float>{
    private var curSize = 0
    override fun set(key: String, value: Float) {
        val searchedNode = isbnMap[key]

        if(searchedNode == null){
            val newNode = LinkedList.Node(
                value = key to value
            )

            lruLinkedList.enqueue(newNode)
            curSize += 1
            isbnMap[key] = newNode

            if(curSize - 1 == size){
                val removedNode = lruLinkedList.dequeue()
                val removedIsbnKey = removedNode.value.first
                isbnMap.remove(removedIsbnKey)
            }
        } else {
            searchedNode.value = key to value
            lruLinkedList.moveHead(searchedNode)
        }
    }

    override fun get(key: String): Float? {
        val node = isbnMap[key] ?: return null

        lruLinkedList.moveHead(node)
        return node.value.second
    }

    override fun size(): Int {
        return curSize
    }

    override fun remove(key: String): Boolean {
        if(curSize == 0) throw IllegalStateException("The cache is empty!!")

        val removedNode = isbnMap[key] ?: return false
        isbnMap.remove(key)
        lruLinkedList.remove(node = removedNode)
        return true
    }
}