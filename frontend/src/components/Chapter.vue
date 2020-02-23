<template>
  <div class="container">
    <h2>{{chapter.chapterName}}</h2>
    <div class="row">
      <div class="col-xs-12 col-md-12">
        <p
          class="text-left lead center-block"
          v-for="(paragraph, index) in chapter.paragraphList"
          :key="index"
        >{{paragraph}}</p>
      </div>
    </div>
    <div id="bottom_navigator" class="row">
      <div class="col-md-4">
        <a href="#" v-if="chapter.previousChapterId != null" @click="previous">上一章</a>
      </div>
      <div class="col-md-4">
        <router-link :to="'/book/' + bookId">章节目录</router-link>
      </div>
      <div class="col-md-4">
        <a href="#" v-if="chapter.nextChapterId != null" @click="next">下一章</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'chapter',
  data() {
    return {
      chapter: {}
    }
  },
  props: {
    bookId: String,
    chapterId: String
  },
  created() {
    this.getChapterById(this.chapterId)
  },
  methods: {
    previous() {
      this.getChapterById(this.chapter.previousChapterId)
    },
    next() {
      this.getChapterById(this.chapter.nextChapterId)
    },
    getChapterById(chapterId) {
      var chapterUrl = '/book/' + this.bookId + '/' + chapterId
      this.$http
        .get(chapterUrl)
        .then(response => {
          this.chapter = response.data
          window.scrollTo(0, 0)
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>
#bottom_navigator {
  margin-top: 15px;
  margin-bottom: 20px;
}
</style>
