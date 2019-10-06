<template>
    <b-container>
        <b-row>
            <b-col col lg="9">
                <b-link href="#/ads">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>
                    Back to result page
                </b-link>
            </b-col>
        </b-row>
        <b-row style="padding-top: 3rem;">
            <b-col col lg="9">
                <b-card v-if="ad"
                        :title="ad.title"
                        tag="article"
                        style="max-width: 60rem;"
                        class="mb-2">
                    <div style="text-align: center">
                        <b-card-img style="max-width: 40rem; max-height: 30rem;" :src="ad.imageUrl"
                                    alt="Image"></b-card-img>
                    </div>
                    <b-card-text style="margin-top: 1rem;">Description</b-card-text>
                    <hr/>
                    <b-card-text>
                        {{ad.description}}
                    </b-card-text>
                </b-card>
            </b-col>
            <b-col col lg="3">
                <b-card>
                    <b-button v-b-modal.contactForm>
                        <font-awesome-icon icon="envelope"></font-awesome-icon>
                        Write Message
                    </b-button>
                </b-card>
            </b-col>
        </b-row>
        <b-row>
            <b-col col lg="9">
                <b-card>
                    <b-card-text>
                        Write a message
                    </b-card-text>
                    <hr/>
                    <b-button v-b-modal.contactForm>
                        <font-awesome-icon icon="envelope"></font-awesome-icon>
                        Write Message
                    </b-button>
                </b-card>
            </b-col>
        </b-row>
        <b-row>
            <contact-form></contact-form>
        </b-row>
    </b-container>
</template>

<script>

    import ContactForm from "../editor/ContactForm.vue";

    export default {
        name: 'ads',
        components: {ContactForm},
        created() {
            this.loadAd()
        },
        data() {
            return {
                ad: null
            }
        },
        methods: {
            loadAd() {
                this.$http.get("ad-single")
                    .then(response => {
                        this.ad = response.body
                    })
            }
        }
    }
</script>