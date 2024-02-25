<template>
    <div class="d-flex flex-column w-100 h-100">        
    <b-modal id="new-movie" title="Nueva película :D" hide-footer>
        <b-form
        @submit.prevent="checkForm"
        action="https://vuejs.org/"
        method="post"
        >
            <b-form-group
            label="Nombre"
            label-for="name"
            >
                <b-form-input
                id="name"
                v-model="name"
                type="text"
                :state="name ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Director"
            label-for="director"
            >
                <b-form-input
                id="director"
                v-model="director"
                type="text"
                :state="director ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Duración en minutos"
            label-for="duratio"
            >
                <b-form-input
                id="duration"
                v-model="duration"
                type="number"
                :state="duration ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Género"
            label-for="genre"

            >
            <b-form-select
            id="genre"
            v-model="genre"
            :options="genres"
            :state="genre ? null : false"
            required
            ></b-form-select>
            </b-form-group>
            <div class="w-100 d-flex justify-content-between">
                <b-button type="button" variant="danger" @click="$bvModal.hide('new-movie')">Cancelar</b-button>
                <b-button type="submit" variant="primary">Guardar</b-button>
            </div>
        </b-form>        
    </b-modal>
    <b-modal id="update-movie" :title="movieUpdate? movieUpdate.name: '' " hide-footer>
        <b-form
        @submit.prevent="checkFormU"
        action="https://vuejs.org/"
        method="put"
        >
            <b-form-group
            label="Nombre"
            label-for="u-name"
            >
                <b-form-input
                id="u-name"
                v-model="movieUpdate.name"
                type="text"
                :state="movieUpdate.name ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Director"
            label-for="u-director"
            >
                <b-form-input
                id="u-director"
                v-model="movieUpdate.director"
                type="text"
                :state="movieUpdate.director ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Duración en minutos"
            label-for="u-duration"
            >
                <b-form-input
                id="u-duration"
                v-model="movieUpdate.duration"
                type="number"
                :state="movieUpdate.duration ? null : false"
                required
                ></b-form-input>
            </b-form-group>
            <b-form-group
            label="Género"
            label-for="u-genre"

            >
            <b-form-select
            id="u-genre"
            v-model="movieUpdate.genre"
            :options="genres"
            :state="movieUpdate.genre ? null : false"
            required
            ></b-form-select>
            </b-form-group>
            <div class="w-100 d-flex justify-content-between">
                <b-button type="button" variant="danger" @click="$bvModal.hide('update-movie')">Cancelar</b-button>
                <b-button type="submit" variant="primary">Guardar</b-button>
            </div>
        </b-form>     
    </b-modal>
    <div class="movie-list-container shadow bg-body-tertiary rounded d-flex flex-column mx-auto mt-5">
        <div class="movie-list-header rounded-top w-100 p-2 border border-secondary-subtle d-flex align-items-center justify-content-between">
            Catálogo de pelíulas
            <b-button v-b-modal.new-movie variant="primary" class="addButton"><b-icon icon="plus"></b-icon></b-button>
        </div>
        <div class="movie-list-scrollframe h-100 mt-2 mx-auto row row-cols-4">
            <div class="col" v-for="movie in movies">
                <div class="card mb-4">
                    <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a45f5b77779815.5c924418f1eaa.jpg" class="card-img-top">
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div class="vstack gap-3">
                            <h5 :title="movie.name" class="trunacate-paragraph card-title">{{ movie.name }}</h5>
                        <div :title="movie.director" class="card-text text-nowrap text-truncate"> Director: {{ movie.director }}</div>
                        <div class="card-text"> Duración: {{ movie.duration }} min</div>
                        <div :title="movie.genre.name" class="card-text text-nowrap text-truncate"> Género: {{ movie.genre.name }}</div>
                        </div>
                        <div class="w-100 d-flex justify-content-between">
                            <b-button variant="danger"><b-icon icon="trash" @click="deleteMovie(movie.id)"></b-icon></b-button>
                            <b-button v-b-modal.update-movie variant="primary" @click="getById(movie.id)"><b-icon icon="pencil"></b-icon></b-button>
                        </div>
                    </div>
                </div>
            </div>         
        </div>
    </div>
    </div>
</template>
<style scoped>
.movie-list-container {
    width: 80%;
    min-height: 60%;
    overflow: hidden;
    position: relative;
    .movie-list-header {
        height: 15%;
        box-sizing: border-box;
    }
    .movie-list-scrollframe {
        overflow: auto;
        width: 95%;
    }
}
.addButton {
    width: 10%;
}
.card {
}
.trunacate-paragraph {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    overflow: hidden;
    -webkit-line-clamp: 2;
}
</style>
<script>
import movieService from '../services/Movie';
export default {
    data() {
        return {
            genres: [],
            movies: [],
            movieUpdate: {
                id: null,
                name: null,
                director: null,
                duration: 0,
                genre: {
                    id: null,
                    name: null,
                }
            },
            name: null,
            director: null,
            duration: 0,
            genre: null,
        }
    },
    mounted() {
        this.getGenres();
        this.getMovies();
    },
    methods: {        
        checkForm: function() {
            this.saveMovie();                
        },
        checkFormU: function() {
            this.updateMovie();
        },
        async getMovies() {
            try {
                const data = await movieService.listMovies();
                this.movies = data;
            } catch(err) {
                console.error(err);
            }
        },
        async getById(id) {
            try {
                const data = await movieService.getMovieById(id);
                this.movieUpdate = data;
                this.movieUpdate.genre = this.movieUpdate.genre.id
                console.log(this.movieUpdate);
            } catch(err) {
                console.error(err);
            }
        },
        async getGenres() {
            try {
                const data = await movieService.listGenre();
                this.genres = data.map(genre => {
                    return {
                        value: genre.id,
                        text: genre.name,
                    }
                });
                this.genres.push({ value: null, text: 'Selecciona una opción' })
            } catch(error) {
                console.error(err);
            }
        },
        async saveMovie() {
            try {
                await movieService.saveMovie({ name: this.name, director: this.director, duration: parseInt(this.duration), genre: parseInt('' + this.genre) }).then(() => {
                    this.name = null;
                    this.director = null;
                    this.duration = null;
                    this.genre = null;
                    window.location.reload();
                });
            } catch(error) {
                console.error(error);
            }
        },
        async deleteMovie(id) {
            try {
                await movieService.deleteMovie(id);
            } catch(err) {
                console.error(err);
            }
        },
        async updateMovie() {
            try {
                await movieService.updateMovie(this.movieUpdate.id, { name: this.movieUpdate.name, director: this.movieUpdate.director, duration: parseInt(this.movieUpdate.duration), genre: this.movieUpdate.genre})
                window.location.reload();
            } catch(err) {
                console.error(err);
            }
        }
    }
}
</script>