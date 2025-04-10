package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String channelId = "my_channel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationChannel();
        findViewById(R.id.button).setOnClickListener(v -> sendNotification());
        findViewById(R.id.button2).setOnClickListener(v -> sendSecondNotification());
        findViewById(R.id.button3).setOnClickListener(v -> sendBigPictureNotification());
    }

    private void notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Kanał Powiadomień";
            String description = "Opis kanału powiadomień";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
        }
        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.grin)
                        .setContentTitle("Nowe powiadomienie dla 4TPEEEEEEE")
                        .setContentText("Jakiś tam tekst")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1, builder.build());


    }

    private void sendSecondNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.grin)
                        .setContentTitle("Nowe drugie powiadomienie dla 4TPEEEEEEE")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Specjalne Czynności Przechowawcze: Instancje SCP-PL-069 przechowywane są w pojemnikach ciśnieniowych na dokumenty. Placówki, w których znajdują się instancje SCP-PL-069, muszą znajdować się min. 10 [km] poza promieniem wpływu obiektu. Obiekty należy składować pod ziemią, na głębokości zapewniającej co najmniej 100 [m] pomiędzy końcem promieniem wpływu instancji a poziomem gruntu. W razie konieczności dokonania interakcji z obiektem, od dyrektora badań placówki oczekuje się stworzenia bezpiecznej przestrzeni badawczej. Interakcje z obiektem należy przeprowadzać za pomocą robota z dala od osób niebędących testerami na co najmniej 100 [m] od końca promienia wpływu instancji. Nikt nie może uzyskać dostępu do obiektu, o ile nie jest to w drodze badań zatwierdzonych przez doktora Bladzińskiego.\n" +
                                "\n" +
                                "W razie odkrycia niezabezpieczonej instancji obiektu należy ją pozyskać metodami zdalnymi za pomocą robota. Przed umieszczeniem nowej instancji w jej docelowej przechowalni należy dokonać jej kopii i umieścić ją w zielonej teczce, w biurze lokalnego menedżera projektu badawczego instancji.\n" +
                                "\n" +
                                "Ofiary, które osiągnęły ostateczne stadium wystawienia na oddziaływanie obiektu, należy zneutralizować bądź zaklasyfikować jako obiekty badawcze. Pozostałe osoby, na które wpływał podmiot, należy poddać doraźnej terapii antymemetycznej doktora Bladzińskiego.\n" +
                                "\n" +
                                "W razie opracowania metody całkowitej neutralizacji instancji należy dokonać tego najszybciej jak to możliwe. Jeżeli obiekt spełnia wyłącznie pierwszy wymóg bądź pierwszy oraz trzeci, należy zakwalifikować go jako instancję bezpieczną, dokonać jej kopii, a następnie ją zneutralizować.\n" +
                                "\n" +
                                "Globalnym menedżerem projektu badawczego SCP-PL-069 jest doktor Bladziński. Do niego bezpośrednio należy składać wszelkie wnioski o umożliwienie uczestnictwa w projekcie, a także te o zezwolenie na przeprowadzenie eksperymentu. Każda osoba może zgłosić propozycję zniszczenia instancji SCP-PL-069.\n" +
                                "\n" +
                                "Opis: SCP-PL-069 to zbiór, na który składają się właściwe instancje obiektu. Kolejne instancje numerowane są liczbami arabskimi, a kryterium kwalifikującym obiekt jako przynależący do zbioru SCP-PL-069 jest spełnienie trzech wymogów:\n" +
                                "\n" +
                                "Podmiot związany jest z cywilizacją namazacką;\n" +
                                "Podmiot przejawia właściwości skrajnego wpływu memetycznego klasy H (przypuszczalnej);\n" +
                                "Nie rozpoznano możliwości absolutnego zniszczenia podmiotu.\n" +
                                "Instancje SCP-PL-069 to pełnomocne dokumenty historyczne, które dotyczą oraz implikują,\n iż na terytorium Polski żyła cywilizacja Namazatu, która nigdy nie została udokumentowana w innych dokumentach, do których Fundacja ma dostęp. Dotychczasowy postęp badawczy nie jest w stanie określić, czy Namazat kiedykolwiek istniał.\n"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(2, builder.build());


    }

    private void sendBigPictureNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
        }
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.card);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.grin)
                        .setContentTitle("Nowe drugie powiadomienie dla 4TPEEEEEEE")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)
                                .setBigContentTitle("zdjęcie"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(3, builder.build());
    }
}