package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.C0;
import com.microsoft.graph.extensions.UserActivity;
import ax.N9.L;
import ax.N9.y0;
import ax.N9.I;
import com.microsoft.graph.extensions.ContactFolder;
import ax.N9.H;
import com.microsoft.graph.extensions.Contact;
import ax.N9.u0;
import com.microsoft.graph.extensions.Person;
import ax.N9.c0;
import com.microsoft.graph.extensions.Event;
import ax.N9.E;
import com.microsoft.graph.extensions.CalendarGroup;
import ax.N9.D;
import ax.N9.j0;
import com.microsoft.graph.extensions.MailFolder;
import ax.N9.k0;
import com.microsoft.graph.extensions.Message;
import ax.N9.d0;
import com.microsoft.graph.extensions.Extension;
import ax.N9.g0;
import com.microsoft.graph.extensions.LicenseDetails;
import ax.N9.K;
import java.util.Arrays;
import com.microsoft.graph.extensions.Onenote;
import com.microsoft.graph.extensions.PlannerUser;
import com.microsoft.graph.extensions.DriveCollectionPage;
import com.microsoft.graph.extensions.Drive;
import com.microsoft.graph.extensions.ProfilePhotoCollectionPage;
import com.microsoft.graph.extensions.ProfilePhoto;
import com.microsoft.graph.extensions.InferenceClassification;
import com.microsoft.graph.extensions.ContactFolderCollectionPage;
import com.microsoft.graph.extensions.ContactCollectionPage;
import com.microsoft.graph.extensions.PersonCollectionPage;
import com.microsoft.graph.extensions.EventCollectionPage;
import com.microsoft.graph.extensions.CalendarGroupCollectionPage;
import com.microsoft.graph.extensions.CalendarCollectionPage;
import com.microsoft.graph.extensions.MailFolderCollectionPage;
import com.microsoft.graph.extensions.MessageCollectionPage;
import com.microsoft.graph.extensions.OutlookUser;
import com.microsoft.graph.extensions.ExtensionCollectionPage;
import com.microsoft.graph.extensions.LicenseDetailsCollectionPage;
import com.microsoft.graph.extensions.DirectoryObjectCollectionPage;
import java.util.Calendar;
import com.microsoft.graph.extensions.MailboxSettings;
import java.util.List;
import ax.T9.e;
import com.microsoft.graph.extensions.PasswordProfile;
import ax.r8.l;
import com.microsoft.graph.extensions.UserActivityCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.DirectoryObject;

public class BaseUser extends DirectoryObject implements d
{
    @a
    @c("onPremisesSyncEnabled")
    public Boolean A;
    public transient UserActivityCollectionPage A0;
    @a
    @c("passwordPolicies")
    public String B;
    private transient l B0;
    @a
    @c("passwordProfile")
    public PasswordProfile C;
    private transient e C0;
    @a
    @c("officeLocation")
    public String D;
    @a
    @c("postalCode")
    public String E;
    @a
    @c("preferredLanguage")
    public String F;
    @a
    @c("provisionedPlans")
    public List<Object> G;
    @a
    @c("proxyAddresses")
    public List<String> H;
    @a
    @c("state")
    public String I;
    @a
    @c("streetAddress")
    public String J;
    @a
    @c("surname")
    public String K;
    @a
    @c("usageLocation")
    public String L;
    @a
    @c("userPrincipalName")
    public String M;
    @a
    @c("userType")
    public String N;
    @a
    @c("mailboxSettings")
    public MailboxSettings O;
    @a
    @c("aboutMe")
    public String P;
    @a
    @c("birthday")
    public Calendar Q;
    @a
    @c("hireDate")
    public Calendar R;
    @a
    @c("interests")
    public List<String> S;
    @a
    @c("mySite")
    public String T;
    @a
    @c("pastProjects")
    public List<String> U;
    @a
    @c("preferredName")
    public String V;
    @a
    @c("responsibilities")
    public List<String> W;
    @a
    @c("schools")
    public List<String> X;
    @a
    @c("skills")
    public List<String> Y;
    public transient DirectoryObjectCollectionPage Z;
    public transient DirectoryObjectCollectionPage a0;
    @a
    @c("manager")
    public DirectoryObject b0;
    public transient DirectoryObjectCollectionPage c0;
    public transient DirectoryObjectCollectionPage d0;
    public transient DirectoryObjectCollectionPage e0;
    public transient DirectoryObjectCollectionPage f0;
    public transient LicenseDetailsCollectionPage g0;
    public transient ExtensionCollectionPage h0;
    @a
    @c("accountEnabled")
    public Boolean i;
    @a
    @c("outlook")
    public OutlookUser i0;
    @a
    @c("assignedLicenses")
    public List<Object> j;
    public transient MessageCollectionPage j0;
    @a
    @c("assignedPlans")
    public List<Object> k;
    public transient MailFolderCollectionPage k0;
    @a
    @c("businessPhones")
    public List<String> l;
    @a
    @c("calendar")
    public com.microsoft.graph.extensions.Calendar l0;
    @a
    @c("city")
    public String m;
    public transient CalendarCollectionPage m0;
    @a
    @c("companyName")
    public String n;
    public transient CalendarGroupCollectionPage n0;
    @a
    @c("country")
    public String o;
    public transient EventCollectionPage o0;
    @a
    @c("department")
    public String p;
    public transient EventCollectionPage p0;
    @a
    @c("displayName")
    public String q;
    public transient PersonCollectionPage q0;
    @a
    @c("givenName")
    public String r;
    public transient ContactCollectionPage r0;
    @a
    @c("imAddresses")
    public List<String> s;
    public transient ContactFolderCollectionPage s0;
    @a
    @c("jobTitle")
    public String t;
    @a
    @c("inferenceClassification")
    public InferenceClassification t0;
    @a
    @c("mail")
    public String u;
    @a
    @c("photo")
    public ProfilePhoto u0;
    @a
    @c("mailNickname")
    public String v;
    public transient ProfilePhotoCollectionPage v0;
    @a
    @c("mobilePhone")
    public String w;
    @a
    @c("drive")
    public Drive w0;
    @a
    @c("onPremisesImmutableId")
    public String x;
    public transient DriveCollectionPage x0;
    @a
    @c("onPremisesLastSyncDateTime")
    public Calendar y;
    @a
    @c("planner")
    public PlannerUser y0;
    @a
    @c("onPremisesSecurityIdentifier")
    public String z;
    @a
    @c("onenote")
    public Onenote z0;
    
    public void d(final e c0, final l b0) {
        this.C0 = c0;
        this.B0 = b0;
        final boolean x = b0.x("ownedDevices");
        final int n = 0;
        if (x) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("ownedDevices@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse.b = b0.t("ownedDevices@odata.nextLink").k();
            }
            final l[] array = (l[])c0.b(b0.t("ownedDevices").toString(), (Class)l[].class);
            final DirectoryObject[] array2 = new DirectoryObject[array.length];
            for (int i = 0; i < array.length; ++i) {
                ((BaseDirectoryObject)(array2[i] = (DirectoryObject)c0.b(((i)array[i]).toString(), (Class)DirectoryObject.class))).d(c0, array[i]);
            }
            baseDirectoryObjectCollectionResponse.a = (List<DirectoryObject>)Arrays.asList((Object[])array2);
            this.Z = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse, (K)null);
        }
        if (b0.x("registeredDevices")) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse2 = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("registeredDevices@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse2.b = b0.t("registeredDevices@odata.nextLink").k();
            }
            final l[] array3 = (l[])c0.b(b0.t("registeredDevices").toString(), (Class)l[].class);
            final DirectoryObject[] array4 = new DirectoryObject[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                ((BaseDirectoryObject)(array4[j] = (DirectoryObject)c0.b(((i)array3[j]).toString(), (Class)DirectoryObject.class))).d(c0, array3[j]);
            }
            baseDirectoryObjectCollectionResponse2.a = (List<DirectoryObject>)Arrays.asList((Object[])array4);
            this.a0 = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse2, (K)null);
        }
        if (b0.x("directReports")) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse3 = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("directReports@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse3.b = b0.t("directReports@odata.nextLink").k();
            }
            final l[] array5 = (l[])c0.b(b0.t("directReports").toString(), (Class)l[].class);
            final DirectoryObject[] array6 = new DirectoryObject[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                ((BaseDirectoryObject)(array6[k] = (DirectoryObject)c0.b(((i)array5[k]).toString(), (Class)DirectoryObject.class))).d(c0, array5[k]);
            }
            baseDirectoryObjectCollectionResponse3.a = (List<DirectoryObject>)Arrays.asList((Object[])array6);
            this.c0 = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse3, (K)null);
        }
        if (b0.x("memberOf")) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse4 = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("memberOf@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse4.b = b0.t("memberOf@odata.nextLink").k();
            }
            final l[] array7 = (l[])c0.b(b0.t("memberOf").toString(), (Class)l[].class);
            final DirectoryObject[] array8 = new DirectoryObject[array7.length];
            for (int l = 0; l < array7.length; ++l) {
                ((BaseDirectoryObject)(array8[l] = (DirectoryObject)c0.b(((i)array7[l]).toString(), (Class)DirectoryObject.class))).d(c0, array7[l]);
            }
            baseDirectoryObjectCollectionResponse4.a = (List<DirectoryObject>)Arrays.asList((Object[])array8);
            this.d0 = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse4, (K)null);
        }
        if (b0.x("createdObjects")) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse5 = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("createdObjects@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse5.b = b0.t("createdObjects@odata.nextLink").k();
            }
            final l[] array9 = (l[])c0.b(b0.t("createdObjects").toString(), (Class)l[].class);
            final DirectoryObject[] array10 = new DirectoryObject[array9.length];
            for (int n2 = 0; n2 < array9.length; ++n2) {
                ((BaseDirectoryObject)(array10[n2] = (DirectoryObject)c0.b(((i)array9[n2]).toString(), (Class)DirectoryObject.class))).d(c0, array9[n2]);
            }
            baseDirectoryObjectCollectionResponse5.a = (List<DirectoryObject>)Arrays.asList((Object[])array10);
            this.e0 = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse5, (K)null);
        }
        if (b0.x("ownedObjects")) {
            final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse6 = new BaseDirectoryObjectCollectionResponse();
            if (b0.x("ownedObjects@odata.nextLink")) {
                baseDirectoryObjectCollectionResponse6.b = b0.t("ownedObjects@odata.nextLink").k();
            }
            final l[] array11 = (l[])c0.b(b0.t("ownedObjects").toString(), (Class)l[].class);
            final DirectoryObject[] array12 = new DirectoryObject[array11.length];
            for (int n3 = 0; n3 < array11.length; ++n3) {
                ((BaseDirectoryObject)(array12[n3] = (DirectoryObject)c0.b(((i)array11[n3]).toString(), (Class)DirectoryObject.class))).d(c0, array11[n3]);
            }
            baseDirectoryObjectCollectionResponse6.a = (List<DirectoryObject>)Arrays.asList((Object[])array12);
            this.f0 = new DirectoryObjectCollectionPage(baseDirectoryObjectCollectionResponse6, (K)null);
        }
        if (b0.x("licenseDetails")) {
            final BaseLicenseDetailsCollectionResponse baseLicenseDetailsCollectionResponse = new BaseLicenseDetailsCollectionResponse();
            if (b0.x("licenseDetails@odata.nextLink")) {
                baseLicenseDetailsCollectionResponse.b = b0.t("licenseDetails@odata.nextLink").k();
            }
            final l[] array13 = (l[])c0.b(b0.t("licenseDetails").toString(), (Class)l[].class);
            final LicenseDetails[] array14 = new LicenseDetails[array13.length];
            for (int n4 = 0; n4 < array13.length; ++n4) {
                ((BaseLicenseDetails)(array14[n4] = (LicenseDetails)c0.b(((i)array13[n4]).toString(), (Class)LicenseDetails.class))).d(c0, array13[n4]);
            }
            baseLicenseDetailsCollectionResponse.a = (List<LicenseDetails>)Arrays.asList((Object[])array14);
            this.g0 = new LicenseDetailsCollectionPage(baseLicenseDetailsCollectionResponse, (g0)null);
        }
        if (b0.x("extensions")) {
            final BaseExtensionCollectionResponse baseExtensionCollectionResponse = new BaseExtensionCollectionResponse();
            if (b0.x("extensions@odata.nextLink")) {
                baseExtensionCollectionResponse.b = b0.t("extensions@odata.nextLink").k();
            }
            final l[] array15 = (l[])c0.b(b0.t("extensions").toString(), (Class)l[].class);
            final Extension[] array16 = new Extension[array15.length];
            for (int n5 = 0; n5 < array15.length; ++n5) {
                ((BaseExtension)(array16[n5] = (Extension)c0.b(((i)array15[n5]).toString(), (Class)Extension.class))).d(c0, array15[n5]);
            }
            baseExtensionCollectionResponse.a = (List<Extension>)Arrays.asList((Object[])array16);
            this.h0 = new ExtensionCollectionPage(baseExtensionCollectionResponse, (d0)null);
        }
        if (b0.x("messages")) {
            final BaseMessageCollectionResponse baseMessageCollectionResponse = new BaseMessageCollectionResponse();
            if (b0.x("messages@odata.nextLink")) {
                baseMessageCollectionResponse.b = b0.t("messages@odata.nextLink").k();
            }
            final l[] array17 = (l[])c0.b(b0.t("messages").toString(), (Class)l[].class);
            final Message[] array18 = new Message[array17.length];
            for (int n6 = 0; n6 < array17.length; ++n6) {
                ((BaseMessage)(array18[n6] = (Message)c0.b(((i)array17[n6]).toString(), (Class)Message.class))).d(c0, array17[n6]);
            }
            baseMessageCollectionResponse.a = (List<Message>)Arrays.asList((Object[])array18);
            this.j0 = new MessageCollectionPage(baseMessageCollectionResponse, (k0)null);
        }
        if (b0.x("mailFolders")) {
            final BaseMailFolderCollectionResponse baseMailFolderCollectionResponse = new BaseMailFolderCollectionResponse();
            if (b0.x("mailFolders@odata.nextLink")) {
                baseMailFolderCollectionResponse.b = b0.t("mailFolders@odata.nextLink").k();
            }
            final l[] array19 = (l[])c0.b(b0.t("mailFolders").toString(), (Class)l[].class);
            final MailFolder[] array20 = new MailFolder[array19.length];
            for (int n7 = 0; n7 < array19.length; ++n7) {
                ((BaseMailFolder)(array20[n7] = (MailFolder)c0.b(((i)array19[n7]).toString(), (Class)MailFolder.class))).d(c0, array19[n7]);
            }
            baseMailFolderCollectionResponse.a = (List<MailFolder>)Arrays.asList((Object[])array20);
            this.k0 = new MailFolderCollectionPage(baseMailFolderCollectionResponse, (j0)null);
        }
        if (b0.x("calendars")) {
            final BaseCalendarCollectionResponse baseCalendarCollectionResponse = new BaseCalendarCollectionResponse();
            if (b0.x("calendars@odata.nextLink")) {
                baseCalendarCollectionResponse.b = b0.t("calendars@odata.nextLink").k();
            }
            final l[] array21 = (l[])c0.b(b0.t("calendars").toString(), (Class)l[].class);
            final com.microsoft.graph.extensions.Calendar[] array22 = new com.microsoft.graph.extensions.Calendar[array21.length];
            for (int n8 = 0; n8 < array21.length; ++n8) {
                ((BaseCalendar)(array22[n8] = (com.microsoft.graph.extensions.Calendar)c0.b(((i)array21[n8]).toString(), (Class)com.microsoft.graph.extensions.Calendar.class))).d(c0, array21[n8]);
            }
            baseCalendarCollectionResponse.a = (List<com.microsoft.graph.extensions.Calendar>)Arrays.asList((Object[])array22);
            this.m0 = new CalendarCollectionPage(baseCalendarCollectionResponse, (D)null);
        }
        if (b0.x("calendarGroups")) {
            final BaseCalendarGroupCollectionResponse baseCalendarGroupCollectionResponse = new BaseCalendarGroupCollectionResponse();
            if (b0.x("calendarGroups@odata.nextLink")) {
                baseCalendarGroupCollectionResponse.b = b0.t("calendarGroups@odata.nextLink").k();
            }
            final l[] array23 = (l[])c0.b(b0.t("calendarGroups").toString(), (Class)l[].class);
            final CalendarGroup[] array24 = new CalendarGroup[array23.length];
            for (int n9 = 0; n9 < array23.length; ++n9) {
                ((BaseCalendarGroup)(array24[n9] = (CalendarGroup)c0.b(((i)array23[n9]).toString(), (Class)CalendarGroup.class))).d(c0, array23[n9]);
            }
            baseCalendarGroupCollectionResponse.a = (List<CalendarGroup>)Arrays.asList((Object[])array24);
            this.n0 = new CalendarGroupCollectionPage(baseCalendarGroupCollectionResponse, (E)null);
        }
        if (b0.x("calendarView")) {
            final BaseEventCollectionResponse baseEventCollectionResponse = new BaseEventCollectionResponse();
            if (b0.x("calendarView@odata.nextLink")) {
                baseEventCollectionResponse.b = b0.t("calendarView@odata.nextLink").k();
            }
            final l[] array25 = (l[])c0.b(b0.t("calendarView").toString(), (Class)l[].class);
            final Event[] array26 = new Event[array25.length];
            for (int n10 = 0; n10 < array25.length; ++n10) {
                ((BaseEvent)(array26[n10] = (Event)c0.b(((i)array25[n10]).toString(), (Class)Event.class))).d(c0, array25[n10]);
            }
            baseEventCollectionResponse.a = (List<Event>)Arrays.asList((Object[])array26);
            this.o0 = new EventCollectionPage(baseEventCollectionResponse, (c0)null);
        }
        if (b0.x("events")) {
            final BaseEventCollectionResponse baseEventCollectionResponse2 = new BaseEventCollectionResponse();
            if (b0.x("events@odata.nextLink")) {
                baseEventCollectionResponse2.b = b0.t("events@odata.nextLink").k();
            }
            final l[] array27 = (l[])c0.b(b0.t("events").toString(), (Class)l[].class);
            final Event[] array28 = new Event[array27.length];
            for (int n11 = 0; n11 < array27.length; ++n11) {
                ((BaseEvent)(array28[n11] = (Event)c0.b(((i)array27[n11]).toString(), (Class)Event.class))).d(c0, array27[n11]);
            }
            baseEventCollectionResponse2.a = (List<Event>)Arrays.asList((Object[])array28);
            this.p0 = new EventCollectionPage(baseEventCollectionResponse2, (c0)null);
        }
        if (b0.x("people")) {
            final BasePersonCollectionResponse basePersonCollectionResponse = new BasePersonCollectionResponse();
            if (b0.x("people@odata.nextLink")) {
                basePersonCollectionResponse.b = b0.t("people@odata.nextLink").k();
            }
            final l[] array29 = (l[])c0.b(b0.t("people").toString(), (Class)l[].class);
            final Person[] array30 = new Person[array29.length];
            for (int n12 = 0; n12 < array29.length; ++n12) {
                ((BasePerson)(array30[n12] = (Person)c0.b(((i)array29[n12]).toString(), (Class)Person.class))).d(c0, array29[n12]);
            }
            basePersonCollectionResponse.a = (List<Person>)Arrays.asList((Object[])array30);
            this.q0 = new PersonCollectionPage(basePersonCollectionResponse, (u0)null);
        }
        if (b0.x("contacts")) {
            final BaseContactCollectionResponse baseContactCollectionResponse = new BaseContactCollectionResponse();
            if (b0.x("contacts@odata.nextLink")) {
                baseContactCollectionResponse.b = b0.t("contacts@odata.nextLink").k();
            }
            final l[] array31 = (l[])c0.b(b0.t("contacts").toString(), (Class)l[].class);
            final Contact[] array32 = new Contact[array31.length];
            for (int n13 = 0; n13 < array31.length; ++n13) {
                ((BaseContact)(array32[n13] = (Contact)c0.b(((i)array31[n13]).toString(), (Class)Contact.class))).d(c0, array31[n13]);
            }
            baseContactCollectionResponse.a = (List<Contact>)Arrays.asList((Object[])array32);
            this.r0 = new ContactCollectionPage(baseContactCollectionResponse, (H)null);
        }
        if (b0.x("contactFolders")) {
            final BaseContactFolderCollectionResponse baseContactFolderCollectionResponse = new BaseContactFolderCollectionResponse();
            if (b0.x("contactFolders@odata.nextLink")) {
                baseContactFolderCollectionResponse.b = b0.t("contactFolders@odata.nextLink").k();
            }
            final l[] array33 = (l[])c0.b(b0.t("contactFolders").toString(), (Class)l[].class);
            final ContactFolder[] array34 = new ContactFolder[array33.length];
            for (int n14 = 0; n14 < array33.length; ++n14) {
                ((BaseContactFolder)(array34[n14] = (ContactFolder)c0.b(((i)array33[n14]).toString(), (Class)ContactFolder.class))).d(c0, array33[n14]);
            }
            baseContactFolderCollectionResponse.a = (List<ContactFolder>)Arrays.asList((Object[])array34);
            this.s0 = new ContactFolderCollectionPage(baseContactFolderCollectionResponse, (I)null);
        }
        if (b0.x("photos")) {
            final BaseProfilePhotoCollectionResponse baseProfilePhotoCollectionResponse = new BaseProfilePhotoCollectionResponse();
            if (b0.x("photos@odata.nextLink")) {
                baseProfilePhotoCollectionResponse.b = b0.t("photos@odata.nextLink").k();
            }
            final l[] array35 = (l[])c0.b(b0.t("photos").toString(), (Class)l[].class);
            final ProfilePhoto[] array36 = new ProfilePhoto[array35.length];
            for (int n15 = 0; n15 < array35.length; ++n15) {
                ((BaseProfilePhoto)(array36[n15] = (ProfilePhoto)c0.b(((i)array35[n15]).toString(), (Class)ProfilePhoto.class))).d(c0, array35[n15]);
            }
            baseProfilePhotoCollectionResponse.a = (List<ProfilePhoto>)Arrays.asList((Object[])array36);
            this.v0 = new ProfilePhotoCollectionPage(baseProfilePhotoCollectionResponse, (y0)null);
        }
        if (b0.x("drives")) {
            final BaseDriveCollectionResponse baseDriveCollectionResponse = new BaseDriveCollectionResponse();
            if (b0.x("drives@odata.nextLink")) {
                baseDriveCollectionResponse.b = b0.t("drives@odata.nextLink").k();
            }
            final l[] array37 = (l[])c0.b(b0.t("drives").toString(), (Class)l[].class);
            final Drive[] array38 = new Drive[array37.length];
            for (int n16 = 0; n16 < array37.length; ++n16) {
                ((BaseDrive)(array38[n16] = (Drive)c0.b(((i)array37[n16]).toString(), (Class)Drive.class))).d(c0, array37[n16]);
            }
            baseDriveCollectionResponse.a = (List<Drive>)Arrays.asList((Object[])array38);
            this.x0 = new DriveCollectionPage(baseDriveCollectionResponse, (L)null);
        }
        if (b0.x("activities")) {
            final BaseUserActivityCollectionResponse baseUserActivityCollectionResponse = new BaseUserActivityCollectionResponse();
            if (b0.x("activities@odata.nextLink")) {
                baseUserActivityCollectionResponse.b = b0.t("activities@odata.nextLink").k();
            }
            final l[] array39 = (l[])c0.b(b0.t("activities").toString(), (Class)l[].class);
            final UserActivity[] array40 = new UserActivity[array39.length];
            for (int n17 = n; n17 < array39.length; ++n17) {
                (array40[n17] = (UserActivity)c0.b(((i)array39[n17]).toString(), (Class)UserActivity.class)).d(c0, array39[n17]);
            }
            baseUserActivityCollectionResponse.a = (List<UserActivity>)Arrays.asList((Object[])array40);
            this.A0 = new UserActivityCollectionPage(baseUserActivityCollectionResponse, null);
        }
    }
}
