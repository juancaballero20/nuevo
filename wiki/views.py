from django.http import JsonResponse
from django.shortcuts import render
from .models import ProgresoCultivo, TipoPlanta, ClimaPlanta, CicloSiembra

def catalogo_view(request):
    tipos_planta = TipoPlanta.objects.all()
    climas_planta = ClimaPlanta.objects.all()
    ciclos_siembra = CicloSiembra.objects.all()

    context = {
        'tipos_planta': tipos_planta,
        'climas_planta': climas_planta,
        'ciclos_siembra': ciclos_siembra,
    }

    return render(request, 'catalogo.html', context)

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
