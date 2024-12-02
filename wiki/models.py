from django.db import models
from django.contrib.auth.models import AbstractUser

# Modelo Usuario


class CustomUser(AbstractUser):
    # Agregar los campos personalizados (ejemplos)
    bio = models.TextField(blank=True, null=True, verbose_name='Biografía')

        
        

# Modelo Catalogo



class Categoria(models.Model):
    nombre = models.CharField(max_length=20, verbose_name="Categoría")

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Categoría"
        verbose_name_plural = "Categorías"
        db_table = "categoria"
        ordering = ['id']


class CicloSiembra(models.Model):
    nombre = models.CharField(max_length=20, verbose_name="Ciclo de Siembra")

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Ciclo de Siembra"
        verbose_name_plural = "Ciclos de Siembra"
        db_table = "ciclo_siembra"
        ordering = ['id']

class TipoPlanta(models.Model):
    nombre = models.CharField(max_length=30, verbose_name="Tipo de Planta")

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Tipo de Planta"
        verbose_name_plural = "Tipos de Planta"
        db_table = "tipo_planta"
        ordering = ['id']

class ClimaPlanta(models.Model):
    nombre = models.CharField(max_length=30, verbose_name="Clima de la Planta")

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Clima de la Planta"
        verbose_name_plural = "Climas de Plantas"
        db_table = "clima_planta"
        ordering = ['id']
        
class Catalogo(models.Model):
    nombre_elemento = models.CharField(max_length=30, verbose_name="Nombre del Elemento")
    ubicacion = models.CharField(max_length=20, verbose_name="Ubicación")
    tipos_cuidado = models.CharField(max_length=15, verbose_name="Tipos de Cuidado")
    requisitos_riego = models.CharField(max_length=30, verbose_name="Requisitos de Riego")
    Categoria = models.ForeignKey(Categoria, on_delete=models.CASCADE, verbose_name="Categorias")
    CicloSiembra = models.ForeignKey(CicloSiembra, on_delete=models.CASCADE, verbose_name="CicloSeimbras")
    TipoPlanta = models.ForeignKey(TipoPlanta, on_delete=models.CASCADE, verbose_name="TiposPlantas")
    ClimaPlanta = models.ForeignKey(ClimaPlanta, on_delete=models.CASCADE, verbose_name="CimaPlantas")


    def __str__(self):
        return self.nombre_elemento

    class Meta:
        verbose_name = "Catálogo"
        verbose_name_plural = "Catálogos"
        db_table = "catalogo"
        ordering = ['id']


# Modelo Viveros
class Viveros(models.Model):
    nombre_vivero = models.CharField(max_length=30, verbose_name="Nombre del Vivero")
    barrio = models.CharField(max_length=30, verbose_name="Barrio")
    direccion_vivero = models.CharField(max_length=30, verbose_name="Dirección del Vivero")
    numero_contacto = models.CharField(max_length=10, verbose_name="Número de Contacto")
    localidad = models.ForeignKey('Localidad', on_delete=models.CASCADE, verbose_name="Localidad")

    def __str__(self):
        return self.nombre_vivero

    class Meta:
        verbose_name = "Vivero"
        verbose_name_plural = "Viveros"
        db_table = "viveros"
        ordering = ['id']

class Localidad(models.Model):
    nombre = models.CharField(max_length=30, verbose_name="Localidad")

    def __str__(self):
        return self.nombre

    class Meta:
        verbose_name = "Localidad"
        verbose_name_plural = "Localidades"
        db_table = "localidad"
        ordering = ['id']


    def __str__(self):
        return self.nombre_de_usuario

    class Meta:
        verbose_name = "Comunidad"
        verbose_name_plural = "Comunidades"
        db_table = "comunidad"
        ordering = ['id']


class ProgresoCultivo(models.Model):
    planta = models.CharField(max_length=100)
    fecha_inicio = models.DateField()
    notas = models.TextField(blank=True, null=True)
    estado = models.CharField(max_length=50)

    def __str__(self):
        return f'{self.planta} - {self.estado}'

    

# Modelo Registro (CustomUser)

    

    # Se puede agregar más campos según las necesidades