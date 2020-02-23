<template>
  <div class="container">
    <div class="row">
      <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
      </button>
    </div>
    <!--
    <div class="row">
      <div class="col-md-8"></div>
      <div class="col-md-4">
        <form role="form">
          <div class="input-group">
            <input type="text" class="form-control" v-model="searchKeyword" />
            <span class="input-group-button" style="padding-left: 8px">
              <button type="submit" class="btn btn-success" @click="search">Search</button>
            </span>
          </div>
        </form>
      </div>
    </div>
    <br />
    -->
    <div class="row">
      <div class="col-xs-12 col-sm-12 col-md-12">
        <table class="table table-hover">
          <tbody>
            <!-- <tr v-for="(book, index) in books.data" :key="index">
              <td>{{ index }}</td>
              <td>
                <router-link :to="'/book/' + book.bookId">{{book.bookName}}</router-link>
              </td>
            </tr>-->
            <tr v-for="index in books.rowNum" :key="index">
              <td>
                <h3>
                  <router-link
                    :to="'/book/' + books.data[index*2 - 2].bookId"
                  >{{books.data[index*2 - 2].bookName}}</router-link>
                </h3>
              </td>
              <td v-if="index*2 - 1 <= books.data.length">
                <h3>
                  <router-link
                    :to="'/book/' + books.data[index*2 - 1].bookId"
                  >{{books.data[index*2 - 1].bookName}}</router-link>
                </h3>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- <div class="row" v-for="index in books.rowNum" :key="index">
      <div class="col-xs-6 col-md-6">
        <div class="thumbnail">
          <div class="caption">
            <h3>
              <router-link
                :to="'/book/' + books.data[index*2 - 2].bookId"
              >{{books.data[index*2 - 2].bookName}}</router-link>
            </h3>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-6">
        <div class="thumbnail">
          <div class="caption">
            <h3>
              <router-link
                :to="'/book/' + books.data[index*2 - 1].bookId"
              >{{books.data[index*2 - 1].bookName}}</router-link>
            </h3>
          </div>
        </div>
      </div>
    </div>-->
  </div>
</template>

<script>
export default {
  name: 'index',
  data() {
    return {
      books: {},
      searchKeyword: ''
    }
  },
  created() {
    this.allBooks()
  },
  methods: {
    splitBooks(data) {
      var rowNum = data.length / 2
      if (data.length % 2 !== 0) {
        rowNum += 1
      }
      return {
        'data': data,
        'rowNum': rowNum
      }
    },
    allBooks() {
      var indexUrl = '/book/'
      this.$http
        .get(indexUrl)
        .then(response => {
          this.books = this.splitBooks(response.data)
        })
        .catch(error => {
          console.log(error)
        })
    },
    search() {
      console.log(this.searchKeyword)
      var keyword = this.searchKeyword.trim()
      if (keyword.length > 0) {
        var searchUrl = '/search/book'
        this.$http
          .get(searchUrl, {
            params: {
              'keyword': keyword
            }
          })
          .then(response => {
            console.log(response)
            this.books = this.splitBooks(response.data)
          }).catch(error => {
            console.log(error)
          })
      } else {
        this.allBooks()
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
