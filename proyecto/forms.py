from django import forms
from wiki.models import CustomUser  # Importa el modelo CustomUser


class RegisterForm(forms.Form):
    username = forms.CharField(required=True, min_length=5, max_length=20,
                               widget=forms.TextInput(attrs={
                                   'class': 'form-control',
                                   'id':'username'
                               }))
    email = forms.EmailField(required=True,
                             widget=forms.EmailInput(attrs={
                                 'class': 'form-control',
                                 'id': 'email'
                                 
                             }))
    password = forms.CharField(required=True,
                                widget=forms.PasswordInput(attrs={
                                   'class': 'form-control'
                               }))
    
def clean_username(self):
        username = self.cleaned_data.get('username')

        if CustomUser.objects.filter(username=username).exists():
            raise forms.ValidationError('El usuario ya existe')

        return username
    
def clean_email(self):
        email = self.cleaned_data.get('email')

        if CustomUser.objects.filter(email=email).exists():
            raise forms.ValidationError('El email ya existe')

        return email
  

def save (self):
    return CustomUser.objects.create_user(
        self.cleaned_data.get('username'),
        self.cleaned_data.get('email'),
        self.cleaned_data.get('password'),
    )
    
from wiki.models import ProgresoCultivo

class ProgresoCultivoForm(forms.ModelForm):
    class Meta:
        model = ProgresoCultivo
        fields = ['planta', 'fecha_inicio', 'notas', 'estado'] 