import os

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

MYSQL = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'proyecto',
        'USER': 'root',
        'PASSWORD': 'juan1102',
        'HOST': 'localhost', 
        'PORT': '3306',
				'OPTIONS': {'init_command': "SET sql_mode='STRICT_TRANS_TABLES'"},
    }
}