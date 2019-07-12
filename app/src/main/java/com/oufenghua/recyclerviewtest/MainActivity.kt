package com.oufenghua.recyclerviewtest

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity(), View.OnClickListener, IMain.View {

    companion object {
        val TAG = "MainActivity"
        val BEST_IN_SCREEN = 18
    }

    private lateinit var adapter: TestAdapter
    private var random = Random(System.currentTimeMillis())

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter() {
        presenter = MainPresenter(this)
    }

    override fun initData() {
        presenter?.start()
    }

    override fun initView() {
    }

    override fun initObserver() {
        fab_add.setOnClickListener(this)
        fab_swap.setOnClickListener(this)
        fab_remove.setOnClickListener(this)
    }

    override fun release() {
        presenter = null
    }

    override fun showRv(items: MutableList<Item>) {
        adapter = TestAdapter(items)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this, 3)
    }

    override fun showAddItemToRv(position: Int) {
        adapter.notifyItemInserted(position)
    }

    override fun showRemoveItemToRv(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun showToast(content: String) {
        ToastUtil.showShort(content)
    }

    override var presenter: IMain.Presenter? = null


    override fun onClick(view: View?) {
        var limit = adapter.itemCount
        when (view?.id) {
            R.id.fab_add -> {
                presenter?.addItem(
                    random.nextInt(
                        0,
                        limit.let { if (it + 1 > BEST_IN_SCREEN) BEST_IN_SCREEN else it + 1 })
                )
//                adapter.add(random.nextInt(0, limit.let { if (it + 1 > BEST_IN_SCREEN) BEST_IN_SCREEN else it + 1 }))
            }
            R.id.fab_swap -> {
                if (limit > 2) {
                    presenter?.swapItem(
                        random.nextInt(0, limit.let { if (it - 1 > BEST_IN_SCREEN) BEST_IN_SCREEN else it - 1 }),
                        random.nextInt(0, limit.let { if (it - 1 > BEST_IN_SCREEN) BEST_IN_SCREEN else it - 1 })
                    )
                } else {
                    ToastUtil.showShort("没什么好换的了")
                }
            }
            R.id.fab_remove -> {
                if (limit > 0) {
                    presenter?.removeItem(
                        random.nextInt(
                            0,
                            limit.let { if (it > BEST_IN_SCREEN) BEST_IN_SCREEN else it })
                    )
                } else {
                    ToastUtil.showShort("没什么好删的了")
                }
            }
            else -> {

            }
        }
    }
}
