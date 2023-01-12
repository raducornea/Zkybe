using IdentityServer_UAC.Configurations;
using IdentityServer_UAC.Data;
using IdentityServer_UAC.Data.Interfaces;
using IdentityServer_UAC.Data.Repositories;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging.Console;
using System.Reflection;

var builder = WebApplication.CreateBuilder(args);
var assembly = typeof(Program).GetTypeInfo().Assembly.GetName().Name;

// Add services to the container.
builder.Services.AddRazorPages();

// logger
builder.Logging.ClearProviders();
builder.Logging.AddSimpleConsole(options =>
{
    options.ColorBehavior = LoggerColorBehavior.Enabled;
});
builder.Logging.SetMinimumLevel(LogLevel.Debug);
builder.Logging.AddFilter("IdentityServer4", LogLevel.Debug);

builder.Services.AddControllersWithViews();

// CORS configuration
builder.Services.AddCors(options =>
{
    options.AddDefaultPolicy(policy =>
    {
        policy.WithOrigins("https://localhost:4200", "http://localhost:4200")
            .AllowAnyHeader()
            .AllowAnyMethod();
    });
});

var serverVersion = new MariaDbServerVersion(new Version(10, 9));
builder.Services.AddDbContext<ZkybeDbContext>(options =>
{
    options.UseMySql(builder.Configuration.GetConnectionString("ZkybeDB"), serverVersion);
});

builder.Services.AddTransient<IUserRepository, UserRepository>();

builder.Services.AddIdentityServer(options =>
{
    options.EmitStaticAudienceClaim = true;
})
    .AddDeveloperSigningCredential()
    .AddConfigurationStore(options =>
    {
        options.ConfigureDbContext = c =>
        {
            c.UseSqlServer(builder.Configuration.GetConnectionString("IdentityServerDB"),
                options => options.MigrationsAssembly(assembly));
        };
    })
    .AddOperationalStore(options =>
    {
        options.ConfigureDbContext = c =>
        {
            c.UseSqlServer(builder.Configuration.GetConnectionString("IdentityServerDB"),
                options => options.MigrationsAssembly(assembly));
        };
    })
    .AddProfileService<ProfileService>()
    .AddResourceOwnerValidator<ResourceOwnerPasswordValidator>();
    //.AddTestUsers(Config.Users.ToList());


var app = builder.Build();

// only migrate the initial data if no other data exists in the database
Config.MigrateInMemoryDataToSqlServer(app);

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseIdentityServer();

app.UseAuthentication();

app.UseAuthorization();

app.UseEndpoints(endpoints =>
{
    endpoints.MapDefaultControllerRoute();
});

app.Run();
