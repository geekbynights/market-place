<template>
    <div>
        <b-modal id="contactForm"
                 ref="contactForm"
                 title="Contact"
                 hide-footer
                 @hidden="emptyFields" no-stacking>
            <b-form-group
                    label-size="md">
                <b-form-input type="text"
                              placeholder="Sender Email Address"
                              v-model="model.email">
                </b-form-input>
            </b-form-group>
            <b-form-group
                    label-size="md">
                <b-form-textarea placeholder="Message"
                                 rows="3"
                                 max-rows="6"
                                 v-model="model.message">
                </b-form-textarea>
            </b-form-group>
            <b-form-group align="center">
                <b-button v-b-modal.confirmation-modal>Send</b-button>
            </b-form-group>
        </b-modal>
        <confirmation-modal></confirmation-modal>
    </div>
</template>

<script>

    import ConfirmationModal from "./ConfirmationModal.vue";
    export default {
        name: 'contact-form',
        components: {ConfirmationModal},
        data() {
            return {
                model: {
                    email: '',
                    message: ''
                }
            }
        },
        methods: {
            sendClicked(event) {
                this.$refs['contactForm'].hide();
            },
            emptyFields() {
                this.model = {
                    email: '',
                    message: ''
                }
            }
        }
    }
</script>