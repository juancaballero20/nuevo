from django.http import JsonResponse
from django.shortcuts import render
from django.shortcuts import redirect

from django.contrib.auth import authenticate
from django.contrib.auth import login
from django.contrib.auth import logout
from .forms import RegisterForm


from django.contrib import messages

from wiki.models import CustomUser, ProgresoCultivo  # Importa el modelo CustomUser


def index(request):
    return render(request,'index.html',{

    })
def plantas(request):
    return render(request, 'plantas.html',{

    })  
def catalogo(request):
    return render(request,'catalogo.html',{

    })
def comunidad(request):
    return render(request,'comunidad.html',{

    })
def contacto(request):
    return render(request,'contacto.html',{

    })
def iniciar(request):
    return render(request,'iniciar.html',{

    })

def recuperar(request):
    return render(request,'recuperar.html',{

    })
def registro(request):
    return render(request,'resgistro.html',{

    })
def sembrado(request):
    return render(request,'sembrado.html',{

    })
def viveros(request):
    return render(request,'viveros.html',{

    })
    # Vista para la página de registro

from django.contrib.auth import get_user_model
from django.db import IntegrityError

def registro(request):
    form = RegisterForm(request.POST or None)
    CustomUser = get_user_model()

    if request.method == 'POST':
        if form.is_valid():
            # Si el formulario es válido, obtener los datos del formulario
            username = form.cleaned_data.get('username')
            email = form.cleaned_data.get('email')
            password = form.cleaned_data.get('password')

            # Comprobar si el nombre de usuario ya existe
            if CustomUser.objects.filter(username=username).exists():
                messages.error(request, 'El nombre de usuario ya existe. Por favor, elige otro nombre de usuario.')
            else:
                try:
                    # Crear el nuevo usuario
                    CustomUser = CustomUser.objects.create_user(username=username, email=email, password=password)

                    # Mensaje de éxito
                    messages.success(request, 'Usuario registrado exitosamente')

                    # Redirigir a la página de inicio de sesión o donde sea necesario
                    return redirect('iniciar')
                except IntegrityError:
                    messages.error(request, 'Ocurrió un error al intentar registrar el usuario. Por favor, intenta nuevamente.')

        else:
            # Si el formulario no es válido, agregar mensajes de error
            messages.error(request, 'Por favor, corrige los errores en el formulario.')

    return render(request, 'registro.html', {'form': form})

        
# Vista para la página de inicio de sesión

def iniciar(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(username=username, password=password)
        if user:
            login(request, user)
            messages.success(request, 'Bienvenido {}'.format(user.username))
            return redirect('index')
        else: 
            messages.error(request, 'Usuario o contraseña incorrectos')
    return render(request, 'iniciar.html',{

    })


def logout_view(request):
    logout(request)
    messages.success(request, 'Sesión finalizada')
    return redirect('iniciar')
def recuperar(request):
    # Aquí agregarás la lógica para recuperar la contraseña (si es necesario)
    return render(request, 'recuperar.html') 

def guardar_progreso(request):
    if request.method == 'POST':
        planta = request.POST.get('planta')
        fecha_inicio = request.POST.get('fecha_inicio')
        notas = request.POST.get('notas')
        estado = request.POST.get('estado')

        # Guardar en la base de datos
        nuevo_progreso = ProgresoCultivo(
            planta=planta,
            fecha_inicio=fecha_inicio,
            notas=notas,
            estado=estado
        )
        nuevo_progreso.save()

        # Devuelve una respuesta de éxito (puedes modificar esto según tus necesidades)
        return JsonResponse({'mensaje': 'Progreso guardado correctamente'})
    else:
        return render(request, 'sembrado.html')
    
def mostrar_progresos(request):
    progresos = ProgresoCultivo.objects.all()
    return render(request, 'sembrado.html', {'progresos': progresos})

    