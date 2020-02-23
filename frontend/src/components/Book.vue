<template>
  <div class="container">
    <h2>{{bookName}}</h2>
    <div v-for="volume in volumes" :key="volume.volumeId">
      <p class="text-left">{{volume.volumeName}}</p>
      <table class="table table-bordered table-condensed">
        <tr v-for="(line, line_index) in volume.chapters" :key="line_index">
          <td class="text-left" v-for="column in line" :key="column.chapterId">
            <router-link :to="'./' + bookId + '/' + column.chapterId">{{column.chapterName}}</router-link>
          </td>
        </tr>
      </table>
      <!-- <div class="row" v-for="(line, line_index) in volume.chapters" :key="line_index">
        <div class="col-md-4" v-for="column in line" :key="column.chapterId">
          <router-link :to="'./' + bookId + '/' + column.chapterId">{{column.chapterName}}</router-link>
        </div>
      </div>-->
    </div>
  </div>
</template>

<script>
export default {
  name: 'book',
  data() {
    return {
      bookName: '',
      volumes: []
    }
  },
  props: {
    bookId: String
  },
  created() {
    var bookUrl = '/book/' + this.bookId
    console.log(bookUrl)
    this.$http.get(bookUrl).then(response => {
      this.bookName = response.data.bookVO.bookName
      this.volumes = []
      response.data.volumeVOS.forEach(volume => {
        var content = []
        var line = []
        volume.chapters.forEach(chapter => {
          line.push(chapter)
          if (line.length === 3) {
            content.push(line)
            line = []
          }
        })
        if (line.length > 0) {
          content.push(line)
        }
        volume.chapters = content
        this.volumes.push(volume)
      })
    }).catch(error => {
      console.log(error)
    })
  }
}
</script>

<style scoped>
</style>
