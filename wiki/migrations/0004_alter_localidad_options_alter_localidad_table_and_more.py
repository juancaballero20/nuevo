# Generated by Django 5.1.2 on 2024-12-02 02:15

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('wiki', '0003_progresocultivo'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='localidad',
            options={'ordering': ['id'], 'verbose_name': 'Comunidad', 'verbose_name_plural': 'Comunidades'},
        ),
        migrations.AlterModelTable(
            name='localidad',
            table='comunidad',
        ),
        migrations.DeleteModel(
            name='Comunidad',
        ),
    ]
