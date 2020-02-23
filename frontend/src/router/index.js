import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Book from '@/components/Book'
import Chapter from '@/components/Chapter'

Vue.use(Router)

var router = new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      meta: {
        title: '逝者如斯夫'
      }
    },
    {
      path: '/book/:bookId',
      name: 'book',
      component: Book,
      meta: {
        title: '目录'
      },
      props: true
    },
    {
      path: '/book/:bookId/:chapterId',
      name: 'chapter',
      component: Chapter,
      meta: {
        title: '章节内容'
      },
      props: true
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

export default router
